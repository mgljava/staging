package com.github.mgljava.staging.service;

public class StringService {

  public String getString(boolean flag) {
    if (flag) {
      return "Hello";
    } else {
      return "Welcome";
    }
  }

  public String getValueBySwitch(int number) {
    switch (number) {
      case 1:
        return "1";
      case 2:
        return "2";
      case 3:
        return "3";
      default:
        return "null";
    }
  }
}
