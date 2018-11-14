package com.github.mgljava.staging.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringOperationTest {

  StringOperation stringOperation;
  @Before
  public void setUp() {
    stringOperation = new StringOperation();
  }

  @Test
  public void should_get_welcome_when_flag_is_false() {
    // given
    boolean flag = false;

    // when
    final String result = stringOperation.getString(flag);

    // then
    assertEquals("Welcome", result);
  }

  @Test
  public void should_get_hello_when_flag_is_true() {
    // given
    boolean flag = true;

    // when
    final String result = stringOperation.getString(flag);

    // then
    assertEquals("Hello", result);
  }
}