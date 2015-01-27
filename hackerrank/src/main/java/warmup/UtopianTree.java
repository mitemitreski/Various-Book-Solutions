package warmup;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/utopian-tree
 */
public class UtopianTree {

  public static void main(String[] args) {
    //simulation approach
    Scanner in = new Scanner(System.in);

    int N = in.nextInt();
    for (int t = N; t > 0; t--) {
      int inNum = in.nextInt();
      System.out.println(calcSeason(inNum));


    }

  }

  private static long calcSeason(int iterations) {
    long height = 1;
    for (int i = 0; i < iterations; i++) {
      if (i % 2 == 0) {
        height *= 2;
      } else {
        height++;
      }
    }
    return height;
  }

}
