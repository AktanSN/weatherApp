package com.aktansanhal.thymeleaff.utilities.results;

public class DataResult<T> extends Result {

    private T data;

    public DataResult(String message, boolean success, T data) {
        super(message, success);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
