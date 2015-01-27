package warmup;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-love-letter-mystery
 */
public class LoveLetter {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int N = Integer.parseInt(in.nextLine());
    for (int t = N; t > 0; t--) {
      String line = in.nextLine();

      System.out.println(calcDiffToPalin(line));

    }

  }

  private static int calcDiffToPalin(String line) {
    final int N = line.length();
    int diff = 0;
    for (int i = 0; i < N / 2; i++) {
      char a = line.charAt(i);
      char b = line.charAt(N - 1 - i);
      diff += Math.abs(a - b);
    }
    return diff;
  }
}
