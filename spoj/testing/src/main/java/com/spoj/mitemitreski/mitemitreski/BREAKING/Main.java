package com.spoj.mitemitreski.mitemitreski.BREAKING;

import java.io.*;
import java.util.BitSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
/*

Input:
3
12
42
84

Output:
Case 1: 2 3
Case 2: 2 3 7
Case 3: 2 3 7


10
13
7
2222
1000000
174763
174751
974763
999999
2
3
 */

public class Main {
    static final int seveLimit = 1000002;

    public static void main(String[] args) throws IOException {

        final BitSet cache = primesSeed(seveLimit);

//        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= testCases; i++) {
            int number = Integer.parseInt(reader.readLine());
            Set<Integer> factors = factors(cache, number);

            String joinedFactors = factors.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" "));

            StringBuilder sb = new StringBuilder("Case ")
                    .append(i)
                    .append(": ")
                    .append(joinedFactors);

            System.out.println(sb);
        }
//        log.flush();
    }

    public static Set<Integer> factors(BitSet cache, final int numberToFactor) {
        Set<Integer> set = new TreeSet<>();

        if (!cache.get(numberToFactor)) {
            set.add(numberToFactor);
            return set;
        }

        int currentNum = numberToFactor;

        while (currentNum % 2 == 0) {
            currentNum /= 2;
            set.add(2);
        }

        if (currentNum > 2) {
            for (int i = 3; i < Math.sqrt(numberToFactor) + 1; i += 2) {
                //is prime i
                if (!cache.get(i)) {
                    while (currentNum % i == 0) {
                        currentNum = currentNum / i;
                        set.add(i);
                    }
                }
                if (currentNum == 1) break;
            }
        }

        return set;
    }

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
}

