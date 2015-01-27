package arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/tutorial-intro
 */
public class Intro {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int v = in.nextInt();
    int N = in.nextInt();
    for (int i = 0; i < N; i++) {
      int num = in.nextInt();
      if (num == v) {
        System.out.println(i);
        return;
      }
    }

  }
}
