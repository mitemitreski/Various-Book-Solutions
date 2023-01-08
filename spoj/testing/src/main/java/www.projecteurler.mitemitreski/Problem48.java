package www.projecteurler.mitemitreski;

import java.math.BigInteger;

public class Problem48 {

  public static void main(String[] args) {

    BigInteger sum = BigInteger.ZERO;
    BigInteger modulo = new BigInteger("10000000000");
    for (int i = 1; i <= 1000; i++) {
      BigInteger num = new BigInteger(i + "");
      sum = sum.add(num.modPow(num, modulo));

    }
    System.out.println(sum.mod(modulo));
  }
}
