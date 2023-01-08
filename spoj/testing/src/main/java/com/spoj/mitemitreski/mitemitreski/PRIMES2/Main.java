package com.spoj.mitemitreski.mitemitreski.PRIMES2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.BitSet;
/*

2
3581
7927
...
999978527
999988747
999999151

 */

public class Main {
    static final int seveLimit = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        final BitSet cache = primesSeed(seveLimit);
        int countPrimes = 500;
        //1000000000
        //
        int maxCases = 100000000;
        for (int i = 2; i < maxCases; i++) {
            if (returnPrime(i, cache)) {
                countPrimes++;
                if (countPrimes == 501) {
                    countPrimes = 0;
                    log.write(i + "\n");
                }
            }
        }
        log.flush();
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

    public static boolean returnPrime(long input, BitSet cache) {
        if (input > seveLimit) {
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
}

