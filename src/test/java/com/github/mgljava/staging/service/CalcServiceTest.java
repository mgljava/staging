package com.github.mgljava.staging.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalcServiceTest {

  @InjectMocks
  private CalcService calcService;

  @Test
  public void should_get_3_when_a_is_1_and_b_is_2() {
    // given
    int a = 1;
    int b = 2;

    // when
    final int result = calcService.add(a, b);
    // then
    assertEquals(3, result);
  }
}