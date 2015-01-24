/**
 * @author mite
 */
public class Problem23 {

  public static boolean isAbundant(int x) {
    return EulerUtil.sumOfAllDivisors(x) > x;
  }

  public static void main(String[] args) {
    long totalSum = 0;
    for (int i = 1; i <= 28123; i++) {
      boolean canBeSumOfTwo = false;
      //we go to half of the number beacuse we dont havte to check twice
      for (int j = 1; j < (i / 2) + 1; j++) {
        if (isAbundant(j) && isAbundant(i - j)) {
          canBeSumOfTwo = true;
          break;
          //if they are a pair leave it go to next
        }

      }

      if (!canBeSumOfTwo) {
        totalSum += i;
      }
//            System.out.println(totalSum);

    }
    System.out.println(totalSum);
  }
}
