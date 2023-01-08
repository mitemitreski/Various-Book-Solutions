package com.projecteurler.mitemitreski.www;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem29 {

  public static void main(String[] args) {
    //brute force
    int[] rangeA = {2, 100};
    int[] rangeB = {2, 100};

    Set<BigInteger> results = new HashSet<>();
    for (int i = rangeA[0]; i <= rangeA[1]; i++) {
      for (int j = rangeB[0]; j <= rangeB[1]; j++) {
        results.add(new BigInteger(i + "").pow(j));
      }
    }

    System.out.println(results.size());

  }
}
