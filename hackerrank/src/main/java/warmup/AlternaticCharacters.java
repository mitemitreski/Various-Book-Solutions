package warmup;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/alternating-characters
 */
public class AlternaticCharacters {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int N = Integer.parseInt(in.nextLine());

    for (int t = N; t > 0; t--) {
      String line = in.nextLine();
      //read char data
      char previous = line.charAt(0);
      int removals = 0;
      for (int i = 1; i < line.length(); i++) {
        char c = line.charAt(i);
        if (c == previous) {
          removals++;
        }
        previous = c;
      }
      System.out.println(removals);
    }
  }

}
