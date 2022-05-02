package com.quintrix.jfs.quintrixspring.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
  protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {

    Error error = new Error();
    error.setMessage("An Error has occurred: ");
    error.setCustomMessage(ex.getMessage());
    error.setHttpStatusCode(HttpStatus.CONFLICT.value());

    return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.CONFLICT, request);
  }
}
