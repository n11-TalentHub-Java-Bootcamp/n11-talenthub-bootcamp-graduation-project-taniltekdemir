package com.taniltekdemir.n11.bootcampgraduationproject.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class CommonException extends RuntimeException {

    public CommonException(String msg) {
        super(msg);
    }
}
