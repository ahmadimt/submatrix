package com.imti.service;

import com.imti.model.Matrix;
import com.imti.model.Rectangle;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * created by imteyaza-1lm on 2019-03-20
 **/
public class MatrixServiceTest {

  @Test
  public void shouldReturnRectangle() {
    MatrixService matrixService = new MatrixServiceImpl();
    ArrayList<Integer> row1 = new ArrayList<>();
    ArrayList<Integer> row2 = new ArrayList<>();
    ArrayList<Integer> row3 = new ArrayList<>();
    ArrayList<Integer> row4 = new ArrayList<>();
    row1.add(1);
    row1.add(0);
    row1.add(0);
    row1.add(0);
    row1.add(0);
    row1.add(1);

    row2.add(0);
    row2.add(1);
    row2.add(1);
    row2.add(1);
    row2.add(0);
    row2.add(0);

    row3.add(0);
    row3.add(1);
    row3.add(1);
    row3.add(1);
    row3.add(0);
    row3.add(0);

    row4.add(0);
    row4.add(0);
    row4.add(0);
    row4.add(1);
    row4.add(0);
    row4.add(0);

    List<List<Integer>> input = new ArrayList<>();
    input.add(row1);
    input.add(row2);
    input.add(row3);
    input.add(row4);
    Matrix matrix = new Matrix();
    matrix.setMatrix(input);
    Rectangle rectangle = matrixService.findMaxSubMatrixRectangle(matrix);
    Assert.assertEquals(1, rectangle.getX());
    Assert.assertEquals(1, rectangle.getY());
    Assert.assertEquals(3, rectangle.getWidth());
    Assert.assertEquals(2, rectangle.getHeight());

  }


}
