package com.api.user.manage.userapimanage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserException.class)
    protected ResponseEntity<UserMessageException> handle(UserException e){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new UserMessageException(e.getMessage()));
    }
}
