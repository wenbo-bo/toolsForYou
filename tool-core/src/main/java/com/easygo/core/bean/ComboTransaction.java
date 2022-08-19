package com.easygo.core.bean;

import com.easygo.common.utils.StringUtil;
import com.easygo.core.factory.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

/**
 * @Author wenbo
 * @Date 2021/3/2 15:05
 **/
@Component
@ConditionalOnClass(ApplicationProperties.class)
public class ComboTransaction {

    public static final String DB1_TX = "rretfd";

    public static final  String DB2_TX = "";

    @Resource
    private Db1TxBroker db1TxBroker;

    @Resource
    private Db2TxBroker db2TxBroker;



    public <V> V inCombinedTx(Callable<V> callable, String[] transactions) {
        if (callable == null) {
            return null;
        }

        Callable<V> combined = Stream.of(transactions)
                .filter(StringUtil::isNotEmpty)
                .distinct()
                .reduce(callable, (r, tx) -> {
                    switch (tx) {
                        case DB1_TX:
                            return () -> db1TxBroker.inTransaction(r);
                        case DB2_TX:
                            return () -> db2TxBroker.inTransaction(r);
                        default:
                            return null;
                    }
                }, (r1, r2) -> r2);

        try {
            return combined.call();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Component
    public class Db1TxBroker {

        @Transactional(rollbackFor = {Exception.class,RuntimeException.class},value = DB1_TX)
        public <V> V inTransaction(Callable<V> callable) {
            try {
                return callable.call();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Component
    public class Db2TxBroker {

        @Transactional(rollbackFor = {Exception.class,RuntimeException.class},value = DB2_TX)
        public <V> V inTransaction(Callable<V> callable) {
            try {
                return callable.call();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}


