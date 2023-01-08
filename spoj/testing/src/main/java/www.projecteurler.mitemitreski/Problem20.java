package www.projecteurler.mitemitreski;

import java.math.BigInteger;

/**
 * @author mite
 */
public class Problem20 {

  public static void main(String[] args) {
    BigInteger num = BigInteger.ONE;
    for (int i = 1; i <= 100; i++) {

//          premature optimization :)
//            if (num.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
//                num=num.divide(BigInteger.TEN);
//            }
      num = num.multiply(new BigInteger(i + ""));

    }
    String strNum = num.toString();
    int sumOfDigits = 0;
    for (int i = 0; i < strNum.length(); i++) {
      char c = strNum.charAt(i);
      sumOfDigits += (c - '0');
    }
    System.out.println("And the solution is " + sumOfDigits);
  }
}
