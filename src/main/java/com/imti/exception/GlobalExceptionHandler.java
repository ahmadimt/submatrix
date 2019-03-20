package com.imti.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * created by imteyaza-1lm on 2019-03-20
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(value = IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ApiErrorResponse> handleWalletNotFoundException(
      final IllegalArgumentException iae) {
    log.error("{}", iae.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), iae.getMessage()));
  }

}
