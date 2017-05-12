package com.learn.rabbitmq.exception;

public class BizDataException extends Exception {

    private static final long serialVersionUID = 8399540964043342437L;

    public BizDataException() {
        super();
    }

    public BizDataException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public BizDataException(String arg0) {
        super(arg0);
    }

    public BizDataException(Throwable arg0) {
        super(arg0);
    }

}
