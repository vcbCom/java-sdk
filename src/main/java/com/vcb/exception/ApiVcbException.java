package com.vcb.exception;


/**
 * 基础异常类
 */
public class ApiVcbException extends RuntimeException {

    private int code;
    private String errorCode;


    public ApiVcbException(int code) {
        super();
        this.code = code;
    }
    public ApiVcbException(int code, String message) {
        super(message);
        this.code = code;
        this.errorCode = "";
    }

    public ApiVcbException(String message) {
        super(message);
        this.code = 500;
    }

    public ApiVcbException(int code, String errorCode, String message) {
        super(message);
        this.code = code;
        this.errorCode = errorCode;
    }

    public int getCode() {
        return code;
    }
}
