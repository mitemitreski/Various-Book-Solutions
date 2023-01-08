package com.spoj.mitemitreski.mitemitreski.COINS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    static final Map<Long, Long> maxCache = new HashMap<>();

    static {
        maxCache.put(0L, 0L);
        maxCache.put(1L, 1L);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(r);
        //abou 10 cases , 0 <= n <= 1 000 000 000.
        while (sc.hasNext()) {
            long n = sc.nextLong();
            System.out.println(getMaxValueForGold(n));
        }

    }

    private static long getMaxValueForGold(long n) {
        long coinA = n / 2;
        long coinB = n / 3;
        long coinC = n / 4;
        if (maxCache.containsKey(n)) {
            return maxCache.get(n);
        }
        long max = Math.max(getMaxValueForGold(coinA) + getMaxValueForGold(coinB) + getMaxValueForGold(coinC), n);
        maxCache.put(n, max);
        return max;
    }

}
/*
Input:
12
2

Output:
13
2
 */