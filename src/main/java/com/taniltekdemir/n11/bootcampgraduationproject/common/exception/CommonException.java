package com.taniltekdemir.n11.bootcampgraduationproject.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class CommonException extends RuntimeException{

    private static final long serialVersionUID = 4657491283614755649L;

    public CommonException(String msg) {
        super(msg);
    }

    public CommonException(String msg, Throwable t) {
        super(msg, t);
    }
}
