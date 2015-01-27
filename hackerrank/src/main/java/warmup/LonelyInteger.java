package warmup;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/lonely-integer
 */
public class LonelyInteger {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int N = in.nextInt();

    Set<Integer> duplicates = new HashSet<>();
    for (int t = N; t > 0; t--) {
      int inNum = in.nextInt();
      if (duplicates.contains(inNum)) {
        duplicates.remove(inNum);
      } else {
        duplicates.add(inNum);
      }
    }
    System.out.println(duplicates.toArray()[0]);

  }
}
