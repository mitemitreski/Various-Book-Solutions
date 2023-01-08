package www.projecteurler.mitemitreski;

import java.util.List;

public class Prob50 {

    public static void main(String[] args) {
        int maxNum = 1000_000;
//        int maxNum = 1000;
        List<Integer> a = EulerUtil.primeListToNum(maxNum);

        int number = 2;
        int howManyPrimes = 1;

//        System.out.println(a.size());
        for (int i = 0; i < a.size(); i++) {
            //start with i
            int currentSum = 0;
            int currentCount = 0;
            for (int j = i; j < a.size(); j++) {
                currentSum += a.get(j);
                currentCount++;

                if (currentSum >= maxNum) {
                    break;
                }
                if (EulerUtil.isPrime(currentSum)) {
                    if (currentCount > howManyPrimes) {
                        howManyPrimes = currentCount;
                        number = currentSum;
                    }

                }
            }
        }

        System.out.println(number + "-------" + howManyPrimes);


    }
}
