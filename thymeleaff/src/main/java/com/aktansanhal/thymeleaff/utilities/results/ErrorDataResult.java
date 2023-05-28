package com.aktansanhal.thymeleaff.utilities.results;

public class ErrorDataResult<T> extends DataResult<T>{
    public ErrorDataResult(String message, T data) {
        super(message, false, data);
    }


}
