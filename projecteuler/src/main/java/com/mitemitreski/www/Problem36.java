package com.mitemitreski.www;

import com.mitemitreski.www.EulerUtil;

/**
 *
 */
public class Problem36 {

  public static void main(String[] args) {
    //brute force 

    long total = 0;
    for (int i = 0; i < 1000000; i++) {
      if (EulerUtil.isPalindrome(i + "") && EulerUtil.isPalindrome(Integer.toBinaryString(i))) {
        total += i;
        System.out.println("--" + i);
      }
    }
    System.out.println(total);
  }

}
