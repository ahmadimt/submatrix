package com.imti.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * created by imteyaza-1lm on 2019-03-20
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse {

  private int status;

  private String message;
}
