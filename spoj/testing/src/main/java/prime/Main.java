package prime;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.BitSet;


public class Main {
    static final int seveLimit = 33974095;


    public static void main(String[] args) throws IOException {

        long a = 1;
        final long div = 1234567890;
        final long moddd = 2147483648L;

        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        log.write("0");
        final BitSet cache = primesSeed(seveLimit);

        int maxIteratons = 3340280;
        while (maxIteratons-- != 0) {
            a = ((a + div) % moddd);
            boolean isPrime = returnPrime(a, cache);
            if (isPrime) {
                log.write('1');
            } else {
                log.write('0');
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
            return number.isProbablePrime(3);
        } else {
            return !cache.get((int) input);
        }
    }
}

