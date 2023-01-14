package com.projecteurler.mitemitreski.www;

import java.util.*;

public class Problem37 {


    public static boolean isTruncatedPrime(int input, Collection<Integer> primes) {
        Set<Integer> truncatedNumbers = new HashSet<>();
        String str = input + "";
        for (int i = 0; i < str.length(); i++) {
            truncatedNumbers.add(Integer.parseInt(str.substring(i)));
            truncatedNumbers.add(Integer.parseInt(str.substring(0, str.length() - i)));
        }
        return primes.containsAll(truncatedNumbers);

    }

    public static void main(String[] args) {

        var primes = EulerUtil.primeListToNum(1000000);
        List<Integer> ignoreList = Arrays.asList(2, 3, 5, 7);
        int sum = 0;
        for (Integer prime : primes) {
            if (isTruncatedPrime(prime, primes)) {
                System.out.println("is trucatable prime " + prime);
                if (!ignoreList.contains(prime)) {
                    sum += prime;
                }
            }

        }
        System.out.println("the sum is" + sum);

    }

}
