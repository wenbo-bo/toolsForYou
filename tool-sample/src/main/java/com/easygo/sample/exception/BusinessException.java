package com.easygo.sample.exception;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wenbo
 */
@Slf4j
@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private int code;
    private String message;

    public BusinessException(int code, String reason) {
        super(reason);
        this.code = code;
        this.message = reason;
    }


    public BusinessException(int code, String reason, Throwable throwable) {
        super(reason, throwable);
        this.code = code;
        this.message = reason;
    }

    public BusinessException(String reason) {
        super(reason);
        this.code = 500;
        this.message = reason;
    }
}
