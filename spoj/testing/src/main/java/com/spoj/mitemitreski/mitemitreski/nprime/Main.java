package com.spoj.mitemitreski.mitemitreski.nprime;

public class Main {
    public static void main(String[] a) {
        var s = new java.util.Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt(),i = 2;
            while (n > 0) if (java.math.BigInteger.valueOf(i++).isProbablePrime(1)) n--;
            System.out.println(i - 1);
        }
    }
}