/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mite
 */
public class Problem30 {

    public static void main(String[] args) {
        long total = 0;
        for (int i = 1000; i < 9999999; i++) {

            String num = i + "";
            int sum = 0;
            for (int j = 0; j < num.length(); j++) {
                sum += Math.pow(num.charAt(j) - '0', 5);

            }
            if (sum == i) {
                total += i;
            }
        }
        System.out.println(total);
    }
}
