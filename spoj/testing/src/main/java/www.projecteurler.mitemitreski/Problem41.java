package www.projecteurler.mitemitreski;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * pandagal prime
 */
public class Problem41 {

    //todo redo to generate panodigital then test vs iterations
    public static void main(String[] args) throws IOException {

        final long max = 987654321L;
//        final long max = 123456789;
        long iterations = 0;
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        long current = max;
        while (current-- > 0) {

            if (isPanoDigital(current)) {
                iterations++;

                out.write(iterations + "  testing number " + current);
                out.newLine();
                out.flush();

                if (EulerUtil.isPrime(current)) {
                    out.write("Found it" + current);
                    out.newLine();
                    out.flush();
                    return;
                }

            }

        }
        out.flush();
        System.out.println("not found?");
    }

    public static boolean isPanoDigital(long max) {

        String maxStr = max + "";
        int maxIndex = maxStr.length() + 1;
        int[] count = new int[maxIndex];
        for (int i = 0; i < maxStr.length(); i++) {
            int value = Character.getNumericValue(maxStr.charAt(i));
            if (value >= maxIndex) {
                //digit bigger then lenght
                return false;
            }
            count[value] = count[value] + 1;
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] != 1) {
                return false;
            }
        }
        return true;
    }

}
