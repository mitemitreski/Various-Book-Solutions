package com.projecteurler.mitemitreski.www;

import java.util.Arrays;

public class Problem24 {


  public static void nextPermuatation(int[] a) {
    int j = a.length - 2;

    while (a[j] > a[j + 1]) {
      j--;
      if (j < 0) {
        Arrays.sort(a);
        j = 0;
      }
    }
    int k = a.length - 1;

    while (a[j] > a[k]) {
      k--;
    }

    swap(a, j, k);
    int r = a.length - 1;
    int s = j + 1;
    while (r > s) {
      swap(a, r, s);
      r = r - 1;
      s = s + 1;
    }


  }

  public static void main(String[] args) {

    int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};// the first permutation
    for (int i = 1; i < 1000000; i++) {
      nextPermuatation(arr);
//            System.out.println(Arrays.toString(arr).replaceAll(", ", ""));
    }
    System.out.println(Arrays.toString(arr).replaceAll(", ", ""));

  }

  private static void swap(int[] array, int aIndex, int bIndex) {
    int temp = array[aIndex];
    array[aIndex] = array[bIndex];
    array[bIndex] = temp;

  }
}
