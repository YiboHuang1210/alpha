package com.hyb.alpha.exception;

/**
 * 自定义异常
 *
 * @author Yibo
 * @version 1.0
 * @since 2018/8/3 17:15
 **/
public class AlphaException extends Exception {

    private static final long serialVersionUID = -6202759931628287239L;
    private static final int DEFAULT_ERROR_CODE = 201;


    /**
     * 错误码,用于返回接口code
     */
    private int errCode;

    public AlphaException(){
        super();
    }

    public AlphaException(String msg) {
        super(msg);
        this.errCode = DEFAULT_ERROR_CODE;
    }
    public AlphaException(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
    }

    public AlphaException(String msg, Throwable e) {
        super(msg,e);
        this.errCode = DEFAULT_ERROR_CODE;
    }

    public AlphaException(int errCode, String msg, Throwable e) {
        super(msg, e);
        this.errCode = errCode;
    }


    public int getErrCode() {
        return errCode;
    }
}
