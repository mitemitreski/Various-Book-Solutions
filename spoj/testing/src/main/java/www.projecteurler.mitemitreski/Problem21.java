package www.projecteurler.mitemitreski;

import www.projecteurler.mitemitreski.EulerUtil;

public class Problem21 {

    public static int d(int x) {
        Integer[] divisors = EulerUtil.getAllDivisors(x);

        Integer sum = 0;
        for (Integer div : divisors) {
            sum += div;
        }

        return sum;
    }

    public static void main(String[] args) {
        int sum = 0;

        for (int a = 1; a < 10000; a++) {
            int b = d(a);


            if (a == d(b) &&a!=b) {
               sum+=a+b;
            }

        }

        // div by 2 beacuse we count them twice
        System.out.println("The final result"+sum/2);
    }
}
