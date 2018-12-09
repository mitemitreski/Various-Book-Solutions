package com.mitemitreski.www;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem18and67 {

  public static int[][] readTable() {
    int[][] table = new int[100][100];

    try {
      int i = 0;
      BufferedReader br = new BufferedReader(new FileReader("src/67.in"));
      String line = br.readLine();
      while (line != null) {
        String[] numbers = line.split(" ");

        for (int j = 0; j < numbers.length; j++) {
          String num = numbers[j];
          table[i][j] = Integer.parseInt(num);
        }


        line = br.readLine();
        i++;

      }

    } catch (IOException ex) {

      ex.printStackTrace();
    }
    return table;
  }

  public static void main(String[] args) throws IOException {


    int[][] table = readTable();


//        EulerUtil.printMatix(x);

    // so we go from bottom to up and callculate using gready
    for (int i = table.length - 1; i > 0; i--) {

      for (int j = 0; j < table[i].length - 1; j++) {
        table[i - 1][j] = table[i - 1][j] + (Math.max(table[i][j], table[i][j + 1]));

      }
    }

    System.out.println(table[0][0]);

  }
}
