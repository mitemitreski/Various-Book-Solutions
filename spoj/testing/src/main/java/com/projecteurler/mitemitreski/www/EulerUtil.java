package com.projecteurler.mitemitreski.www;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class EulerUtil {

    public static <T> void printMatix(T[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");

            }
            System.out.println("");
        }
    }

    public static  void printMatix(int[][] a) {
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

    public static final int SEED_LIMIT = 100001;
    public static BitSet primesSeed = primesSeed(SEED_LIMIT);


    public static BitSet primesSeed(int limit) {
        final BitSet isNotPrime = new BitSet(limit);
        isNotPrime.set(0, true);
        isNotPrime.set(1, true);
        final int limitRoot = (int) Math.sqrt(limit);
        for (int p = 2; p <= limitRoot; p++) {
            if (!isNotPrime.get(p)) {
                for (int j = p * 2; j <= limit; j += p) {
                    isNotPrime.set(j, true);
                }
            }
        }
        return isNotPrime;
    }


    public static boolean returnPrime(long input, BitSet cache) {
        if (input > SEED_LIMIT) {
            if (input % 2 == 0 ||
                    input % 3 == 0 ||
                    input % 5 == 0 ||
                    input % 7 == 0 ||
                    input % 11 == 0 ||
                    input % 13 == 0 ||
                    input % 17 == 0 ||
                    input % 19 == 0 ||
                    input % 23 == 0 ||
                    input % 29 == 0 ||
                    input % 31 == 0
            ) {
                return false;
            }
            BigInteger number = BigInteger.valueOf(input);
            return number.isProbablePrime(1);
        } else {
            return !cache.get((int) input);
        }
    }

    public static boolean isPrime(long x) {
        return returnPrime(x, primesSeed);
    }

    public static List<Integer> primeListToNum(int x) {
        if (x >= SEED_LIMIT) {
            throw new RuntimeException("too low seed");
        }
        List<Integer> total = new ArrayList<>();

        for (int i = 2; i <= x; i++) {
            if (!primesSeed.get(i)) {
                total.add(i);
            }
        }
        return total;

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
