package com.easygo.core.aspect;

import com.easygo.core.annotation.MultiTransactional;
import com.easygo.core.bean.ComboTransaction;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author wenbo
 * @Date 2021/3/2 15:03
 **/
@Aspect
@Component
@Order(1)
public class MultiTransactionAop {

    private final ComboTransaction comboTransaction;

    @Autowired
    public MultiTransactionAop(ComboTransaction comboTransaction) {
        this.comboTransaction = comboTransaction;
    }


    @Pointcut("@annotation(com.easygo.core.annotation.MultiTransactional)")
    public void pointCut() {
    }

    @Around("pointCut() && @annotation(multiTransactional)")
    public Object inMultiTransactions(ProceedingJoinPoint pjp, MultiTransactional multiTransactional) {
        return comboTransaction.inCombinedTx(() -> {
            try {
                return pjp.proceed();
            } catch (Throwable throwable) {
                if (throwable instanceof RuntimeException) {
                    throw (RuntimeException) throwable;
                }
                throw new RuntimeException(throwable);
            }
        }, multiTransactional.value());
    }

}
