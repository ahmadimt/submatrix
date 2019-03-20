package com.imti.api;

import com.imti.model.Matrix;
import com.imti.service.MatrixService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by imteyaza-1lm on 2019-03-20
 **/
@RestController
@RequestMapping(value = MatrixResources.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MatrixResources {

  static final String BASE_URL = "/api/v1/";

  private final MatrixService service;

  @Autowired
  public MatrixResources(MatrixService service) {
    this.service = service;
  }

  @PostMapping(value = "/matrix")
  public ResponseEntity<Response> findSubMatrix(@RequestBody Matrix matrix) {
    validateRequestInput(matrix);
    return ResponseEntity.ok(new Response(service.findMaxSubMatrixRectangle(matrix)));
  }

  private void validateRequestInput(Matrix matrix) {

    List<List<Integer>> input = matrix.getMatrix();

    if (input.isEmpty() || input.get(0).isEmpty()) {
      throw new IllegalArgumentException("Empty matrix..please input some data in matrix");
    }

    int colSize = input.get(0).size();
    for (List<Integer> cols : input) {
      if (cols.size() != colSize) {
        throw new IllegalArgumentException("Matrix rows should contain same number of columns");
      }
    }
  }
}
