package com.projecteurler.mitemitreski.www;


import java.math.BigInteger;
import java.util.List;

public class Problem26 {

    public static void main(String[] args) {
        // https://en.wikipedia.org/wiki/Cyclic_number form based

        int maxValue = 1000;
        List<Integer> allPrimesToNum = EulerUtil.primeListToNum(1001);
        BigInteger max = BigInteger.ONE;
        int primeMax = 1;
        //Decimal base
        int b = 10;

        int t = 0;
        int r = 1;
        int n = 0;

        for (Integer prime : allPrimesToNum) {
            //skip number that divde the base
            if (b % prime == 0) continue;
            do {
                t++;
                int x = r * b;
                int d = (int) Math.floor(x / prime);
                r = x % prime;
                n = (n * b) + d;
            } while (r != 1);
            if (t == prime - 1) {
                if ((n + "").length() > max.toString().length()) {
                    n = prime;
//                primeMax = prime;

                }

//            BigInteger total = BigInteger.valueOf(10)
//                    .pow(prime - 1)
//                    .divide(BigInteger.valueOf(prime));
//            System.out.println(prime + "  " + total);
//
            }


        }
        System.out.println(primeMax + "---- " + max);
    }
}
