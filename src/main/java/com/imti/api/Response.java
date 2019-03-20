package com.imti.api;

import com.imti.model.Rectangle;
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
@AllArgsConstructor
@NoArgsConstructor
public class Response {

  private Rectangle submatrix;
}
