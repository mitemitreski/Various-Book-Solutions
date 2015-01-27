package warmup;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maximizing-xor
 *
 * simulation.
 */
public class MaxiXor {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    final int L = in.nextInt();
    final int R = in.nextInt();
    int max = L ^ R;
    for (int i = L; i <= R; i++) {
      for (int j = L; j <= R; j++) {
        int num = i ^ j;
        if (num > max) {
          max = num;
        }
      }
    }
    System.out.println(max);
  }
}
