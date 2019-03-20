package com.imti.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.imti.model.Rectangle;
import com.imti.service.MatrixService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * created by imteyaza-1lm on 2019-03-20
 **/
@RunWith(SpringRunner.class)
@WebMvcTest(MatrixResources.class)
public class MatrixResourcesTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MatrixService matrixService;

  private Rectangle rectangle = new Rectangle();

  @Test
  public void shouldReturnResponse() throws Exception {
    Mockito.when(
        matrixService.findMaxSubMatrixRectangle(Mockito.any())).thenReturn(rectangle);
    mockMvc.perform(post("/api/v1/matrix")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
            "{ \"matrix\": [ [ 1,0,0,0,0,1 ], [ 0,1,1,1,0,0 ], [ 0,1,1,1,0,0 ], [ 0,0,0,1,0,0 ] ]}")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.submatrix").exists());
  }

  @Test
  public void shouldThrowExceptionOnEmptyMatrix() throws Exception {
    Mockito.when(
        matrixService.findMaxSubMatrixRectangle(Mockito.any())).thenReturn(rectangle);
    mockMvc.perform(post("/api/v1/matrix")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
            "{ \"matrix\": []}")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError())
        .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message")
            .value("Empty matrix..please input some data in matrix"));
  }

  @Test
  public void shouldThrowExceptionOnVaryingColumn() throws Exception {
    Mockito.when(
        matrixService.findMaxSubMatrixRectangle(Mockito.any())).thenReturn(rectangle);
    mockMvc.perform(post("/api/v1/matrix")
        .contentType(MediaType.APPLICATION_JSON)
        .content(
            "{ \"matrix\": [ [ 1,0,0,0 ], [ 0,1,1,1,0,0 ], [ 0,1,1,1,0,0 ], [ 0,0,0,1,0,0 ] ]}")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError())
        .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message")
            .value("Matrix rows should contain same number of columns"));
  }
}
