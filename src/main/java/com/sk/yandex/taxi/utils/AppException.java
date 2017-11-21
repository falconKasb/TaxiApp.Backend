package com.sk.yandex.taxi.utils;

import org.springframework.http.HttpStatus;

/**
 * Created by sanchirkartiev on 3/15/17.
 */
public class AppException extends Exception {

    private static final long serialVersionUID = 1L;
    private String message = null;
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public AppException(String message) {
        super(message);
        this.message = message;
    }

    public AppException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}