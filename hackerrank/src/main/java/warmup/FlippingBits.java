package warmup;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/flipping-bits
 */
public class FlippingBits {


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int N = in.nextInt();
    for (int t = N; t > 0; t--) {
      long inNum = in.nextLong();
      inNum = ~inNum;
      long num = inNum & 0xffffffffL;
      System.out.println(Long.toUnsignedString(num));


    }


  }
}
