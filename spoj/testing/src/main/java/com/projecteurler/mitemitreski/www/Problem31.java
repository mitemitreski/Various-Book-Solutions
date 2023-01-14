package com.projecteurler.mitemitreski.www;


import java.util.Arrays;

public class Problem31 {

    public static int countWays(int[] coins, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0 || coins.length == 0) {
            return 0;
        }
        // sub prolbme 1  is the targer - current coin   +   the ways to reach the target without the coin
        return countWays(coins, target - coins[0]) + countWays(Arrays.copyOfRange(coins, 1, coins.length), target);
    }


    public static void main(String[] args) {
        int target = 200;
        int[] coinSizes = { 1, 2, 5, 10, 20, 50, 100, 200 };
        System.out.println(countWays(coinSizes,target));
    }

}
