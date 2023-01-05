package com.mitemitreski.www;

import com.google.common.collect.Maps;
import com.mitemitreski.www.EulerUtil;

import java.util.Map;

/**
 * Digit factorials.
 */
public class Problem34 {

  public static void main(String[] args) {
    Map<Long, Long> digitsFactMap = Maps.newHashMap();
    digitsFactMap.put(0L, EulerUtil.factorial(0));
    digitsFactMap.put(1L, EulerUtil.factorial(1));
    digitsFactMap.put(2L, EulerUtil.factorial(2));
    digitsFactMap.put(3L, EulerUtil.factorial(3));
    digitsFactMap.put(4L, EulerUtil.factorial(4));
    digitsFactMap.put(5L, EulerUtil.factorial(5));
    digitsFactMap.put(6L, EulerUtil.factorial(6));
    digitsFactMap.put(7L, EulerUtil.factorial(7));
    digitsFactMap.put(8L, EulerUtil.factorial(8));
    digitsFactMap.put(9L, EulerUtil.factorial(9));

    long total = 0;
    for (long i = 9; i < 1000000; i++) {
      long sum = 0;
      long num = i;
      while (num != 0) {
        long digit = num % 10;
        num = num / 10;
        sum += digitsFactMap.get(digit);
      }
      if (sum == i) {
        total += i;
        System.out.println("--" + i);
      }
    }
    System.out.println("total -  " + total);
  }
}
