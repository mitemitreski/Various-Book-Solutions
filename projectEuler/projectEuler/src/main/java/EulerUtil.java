import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class EulerUtil {

  public static void printMatix(Object[][] a) {

    for (int i = 0; i < a.length; i++) {

      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");

      }
      System.out.println("");
    }
  }

  public static int sumOfAllDivisors(int x) {

    Integer[] allDivisors = getAllDivisors(x);
    int sum = 0;

    for (int i = 0; i < allDivisors.length; i++) {
      sum += allDivisors[i];

    }

    return sum;


  }

  public static Integer[] getAllDivisors(int x) {
    HashSet<Integer> divisorList = new HashSet<Integer>();
    divisorList.add(1);
    final int max = (int) (Math.round(Math.sqrt(x)) + 1);
    for (int i = 2; i < max; i++) {
      if (x % i == 0) {
        divisorList.add(i);
        divisorList.add(x / i);
      }
    }
    return divisorList.toArray(new Integer[0]);

  }

  public static String readFromFile(String filename) {
    String content = "";
    try {


      BufferedReader br = new BufferedReader(new FileReader(filename));
      String line = br.readLine();
      while (line != null) {
        content += line;

        line = br.readLine();

      }
    } catch (IOException ex) {
      ex.printStackTrace();

    }

    return content;
  }

  private static final TreeSet<Long> primes = new TreeSet<>();

  static {
    primes.add(2L);
    primes.add(3L);
    primes.add(5L);
    primes.add(7L);
    primes.add(11L);
    primes.add(13L);
  }

  public static boolean isPrime(long x) {

    if (primes.contains(x)) {
      return true;
    }


    for (int i = 2; i < (Math.sqrt(x) + 2); i++) {
//            System.out.println(i);
      if (x % i == 0) {
        return false;
      }
    }
    primes.add(x);
    return true;
  }

  public static long factorial(int num) {
    long fact = 1;
    for (int i = 1; i <= num; i++) {
      fact = fact * i;
    }
    return fact;
  }


  public static boolean isPalindrome(String value) {
    int N = value.length();
    if (N < 2) {
      return true;
    }
    for (int i = 0; i < N / 2; i++) {
      if (value.charAt(i) != value.charAt(N - i - 1)) {
        return false;
      }
    }

    return true;
  }


  public static Set<String> permutation(String str) {
    Set<String> permutations = new HashSet<>();
    permutation("", str, permutations);
    return permutations;
  }

  private static void permutation(String prefix, String str, Set<String> permutations) {
    int n = str.length();
    if (n == 0) {
      permutations.add(prefix);
    } else {
      for (int i = 0; i < n; i++)
        permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), permutations);
    }
  }
}
