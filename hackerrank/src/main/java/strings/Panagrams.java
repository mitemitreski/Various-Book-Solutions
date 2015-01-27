package strings;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/pangrams
 */
public class Panagrams {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    final Set<Character> alphabet = new TreeSet<Character>();
    for (int i = 'a'; i <= 'z'; i++) {
      alphabet.add((char) i);
    }

    String s = in.nextLine().toLowerCase();
    s.codePoints().forEach((c) -> {
      alphabet.remove((char) c);
    });

    if (alphabet.isEmpty()) {
      System.out.println("pangram");
    } else {
      System.out.println("not pangram");
    }
  }
}

