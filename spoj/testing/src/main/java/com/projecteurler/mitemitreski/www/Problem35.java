package com.projecteurler.mitemitreski.www;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class Problem35 {


    public static void main(String[] args) {
        int countAll = 0;
        List<Integer> primes = EulerUtil.primeListToNum(1000000);
        System.out.println("total primes "+ primes.size());
        for (Integer prime : primes) {
            Set<Integer> allRotations = generateAllDigitVariations(prime);
            boolean allPermutationsWerePrime = primes.containsAll(allRotations);
            if (allPermutationsWerePrime) {
                //it is a circular prime
                System.out.println("++++++  " + prime);
                countAll++;
            }
        }
        System.out.println("count is " + countAll);
    }

    public static Set<Integer> generateAllDigitVariations(Integer number) {
        String str = number + "";
        Set<Integer> out = new HashSet<>();
        Set<String> all = EulerUtil.allRotationsOnAString(str);
        for (String rotation : all) {
            out.add(Integer.valueOf(rotation));
        }
        return out;

    }


}