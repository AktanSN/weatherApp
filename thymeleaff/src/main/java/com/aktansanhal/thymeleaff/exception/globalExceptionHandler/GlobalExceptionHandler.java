package com.aktansanhal.thymeleaff.exception.globalExceptionHandler;


import com.aktansanhal.thymeleaff.exception.exceptions.MyException;
import com.aktansanhal.thymeleaff.utilities.results.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MyException.class})
    public ResponseEntity<Result> notfound(MyException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Result(exception.getMessage(),false));
    }


}
