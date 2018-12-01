import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Problem35 {


  public static void main(String[] args) {

    int countAll = 0;
    outter:
    for (int i = 2; i < 1000000; i++) {
      if (EulerUtil.isPrime(i)) {
        String str = i + "";
        if (i > 10 && (str.contains("2") || str.contains("4") || str.contains("0"))) {
          continue;

        }
        Set<Long> allPermutations = generateAllDigitVariations(str);
        for (Long permutation : allPermutations) {
          if (!EulerUtil.isPrime(permutation)) {
            continue outter;
          }
        }
        //it is a circular prime
        System.out.println("--" + i);
        countAll++;

      }

    }
    System.out.println(countAll);
  }

  public static Set<Long> generateAllDigitVariations(String str) {
    Set<Long> out = new HashSet<>();
    Set<String> all = EulerUtil.permutation(str);
    for (String permutation : all) {
      out.add(Long.valueOf(permutation));
    }
    return out;

  }


}