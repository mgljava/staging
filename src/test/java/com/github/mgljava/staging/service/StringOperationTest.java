package com.github.mgljava.staging.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringOperationTest {

  StringService service;

  @Before
  public void setUp() {
    service = new StringService();
  }

  @Test
  public void should_get_welcome_when_flag_is_false() {
    // given

    // when
    final String result = service.getString(false);

    // then
    assertEquals("Welcome", result);
  }

  @Test
  public void should_get_hello_when_flag_is_true() {
    // given

    // when
    final String result = service.getString(true);

    // then
    assertEquals("Hello", result);
  }

  @Test
  public void should_get_1_when_number_is_1() {
    // given
    int number = 1;

    // when
    final String valueBySwitch = service.getValueBySwitch(number);

    // then
    assertEquals("1", valueBySwitch);
  }

  @Test
  public void should_get_2_when_number_is_2() {
    // given
    int number = 2;

    // when
    final String valueBySwitch = service.getValueBySwitch(number);

    // then
    assertEquals("2", valueBySwitch);
  }

  @Test
  public void should_get_3_when_number_is_3() {
    // given
    int number = 3;

    // when
    final String valueBySwitch = service.getValueBySwitch(number);

    // then
    assertEquals("3", valueBySwitch);
  }

  @Test
  public void should_get_4_when_number_is_4() {
    // given
    int number = 4;

    // when
    final String valueBySwitch = service.getValueBySwitch(number);

    // then
    assertEquals("4", valueBySwitch);
  }

  @Test
  public void should_get_5_when_number_is_5() {
    // given
    int number = 5;

    // when
    final String valueBySwitch = service.getValueBySwitch(number);

    // then
    assertEquals("5", valueBySwitch);
  }

  @Test
  public void should_get_default_when_number_is_default() {
    // given
    int number = 6;

    // when
    final String valueBySwitch = service.getValueBySwitch(number);

    // then
    assertEquals("null", valueBySwitch);
  }
}