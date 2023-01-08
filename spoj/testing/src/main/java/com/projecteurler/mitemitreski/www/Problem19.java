package com.projecteurler.mitemitreski.www;

import java.util.Calendar;

/**
 * @author mite
 */
public class Problem19 {

  public static void main(String[] args) {
    int count = 0;
    for (int i = 1901; i <= 2000; i++) {
      Calendar d = Calendar.getInstance();
      d.set(i, 1, 1);
      for (int j = 1; j <= d.getActualMaximum(Calendar.DAY_OF_YEAR); j++) {
        d.set(Calendar.DAY_OF_YEAR, j);

        if (d.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY && d.get(Calendar.DAY_OF_MONTH) == 1) {
          count++;
        }
      }


    }
    System.out.println(count);

  }
}
