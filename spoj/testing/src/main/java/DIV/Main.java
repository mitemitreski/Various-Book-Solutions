package DIV;

import java.io.*;
import java.util.BitSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
/*

 */

public class Main {
    static final int seveLimit = 1000001;

    public static void main(String[] args) throws IOException {

        final BitSet cache = primesSeed(seveLimit);

        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 2; i < 1000000; i++) {
            Set<Integer> factors = factors(cache, i);

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

