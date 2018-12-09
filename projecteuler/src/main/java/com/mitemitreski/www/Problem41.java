package com.mitemitreski.www;

import com.mitemitreski.www.EulerUtil;

import java.util.Set;
import java.util.TreeSet;

/**
 * pandagal prime
 */
public class Problem41 {

  public static void main(String[] args) {
    for (int i = 0; i < 10000; i++) {
      EulerUtil.isPrime(i);
    }

    long max = 9876543201L;
//    long max = 43210L;

    while (max > 0) {
      max -= 2;
      if (EulerUtil.isPrime(max)) {
        if (noDuplicateDigits(max)) {
          System.out.println(max);
          return;

        }
      }

    }
    System.out.println("not found?");
  }

  private static boolean noDuplicateDigits(long max) {
//    System.out.println("--" + max);
    Set<Integer> duplicates = new TreeSet<>();

    while (max != 0) {
//      System.out.println(duplicates);
      int digit = (int) (max % 10);
      if (duplicates.contains(digit)) {
        return false;
      }
      duplicates.add(digit);
      max /= 10;
    }
    return true;
  }

}
