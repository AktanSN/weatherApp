package com.aktansanhal.thymeleaff.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{


    public SuccessDataResult(String message, T data) {
        super(message, true, data);
    }
}
