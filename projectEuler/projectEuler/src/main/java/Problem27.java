
/**
 *
 * @author mite
 */
public class Problem27 {
    /*
     *
    n^2+ a*n+b
     */

    public static void main(String[] args) {

        int maxN = 0;
        int product = 0;
        for (int a = -999; a <= 999; a++) {
            for (int b = -999; b <= 999; b++) {
                for (int n = 0; n <= 800; n++) {

                    long expresion = n * n + a * n + b;


                    if (!EulerUtil.isPrime(Math.abs(expresion))) {
                        if (maxN < (n - 1)) {
                            maxN = n - 1;
                            product = a * b;

                        }

                        break;
                    }

                }
            }
        }
        System.out.println(maxN + " " + product);
    }
}
