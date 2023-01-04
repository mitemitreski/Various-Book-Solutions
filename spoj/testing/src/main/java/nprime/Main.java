package nprime;

import java.util.*;

public class Main {
    public static void main(String[] a) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int i = 2;
            while (n > 0) if (java.math.BigInteger.valueOf(i++).isProbablePrime(1)) n--;
            System.out.println(i - 1);
        }
    }
}

