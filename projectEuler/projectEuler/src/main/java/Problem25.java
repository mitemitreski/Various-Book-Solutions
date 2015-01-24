import java.math.BigInteger;

/**
 * @author mite
 */
public class Problem25 {

  /*
   *
  a=1
  b=1
  c=a+b

   *
   */
  public static void main(String[] args) {

    BigInteger a = BigInteger.ONE;
    BigInteger b = BigInteger.ONE;
    BigInteger c = null;
    long index = 3;
    while (true) {
      c = a.add(b);
      a = b;
      b = c;

      if (c.toString().length() >= 1000) break;
      index++;
    }
    System.out.println(index);
  }
}
