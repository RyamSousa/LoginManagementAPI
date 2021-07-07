package com.api.user.manage.userapimanage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class LoginExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LoginException.class)
    protected ResponseEntity<LoginMessageException> handle(LoginException e){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new LoginMessageException(e.getMessage()));
    }
}
