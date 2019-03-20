package com.imti.service;

import com.imti.model.Matrix;
import com.imti.model.Rectangle;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * created by imteyaza-1lm on 2019-03-20
 **/
@Service
public class MatrixServiceImpl implements MatrixService {

  @Override
  public Rectangle findMaxSubMatrixRectangle(Matrix matrix) {
    List<List<Integer>> input = matrix.getMatrix();
    return doFind(input);
  }

  private Rectangle doFind(List<List<Integer>> input) {
    Rectangle rectangle = new Rectangle();
    int row;
    int col;
    row = input.size();
    col = input.get(0).size();
    int[][] temp = new int[row][col];
    createTempMatrix(temp, input, row, col);
    int min;
    int x = 0;
    int y = 0;
    for (int i = 0; i < row; i++) {
      int count = 0;
      for (int j = 0; j < col; j++) {
        if (input.get(i).get(j) == 1) {
          min = temp[i][j];
          int k;
          for (k = i; k < row && input.get(k).get(j) == 1; k++) {
            min = Math.min(min, temp[k][j]);
            count++;
          }
          if (rectangle.getWidth() < min) {
            rectangle.setWidth(min);
            rectangle.setHeight(count);
          }
        }

      }

    }

    int maxValue = temp[0][0];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (temp[i][j] > maxValue) {
          maxValue = temp[i][j];
          x = i;
          y = j;
        }
      }
    }
    rectangle.setX(x);
    rectangle.setY(y);
    return rectangle;
  }

  private void createTempMatrix(int[][] temp, List<List<Integer>> input, int row, int col) {
    for (int i = 0; i < row; i++) {
      if (input.get(i).get(col - 1) == 1) {
        temp[i][col - 1] = 1;
      } else {
        temp[i][col - 1] = 0;
      }
    }

    for (int i = 0; i < row; i++) {
      for (int j = col - 2; j >= 0; j--) {
        if (input.get(i).get(j) == 0) {
          temp[i][j] = 0;
        } else {
          temp[i][j] = temp[i][j + 1] + 1;
        }
      }
    }
  }
}
