package com.projecteurler.mitemitreski.www;

import java.io.IOException;


public class Problem40 {


    public static void main(String[] args) throws IOException {
        StringBuilder out = new StringBuilder("");
        for (int i = 0; i < 1000000; i++) {
            out.append(i);
        }
        int digits = 12;

        System.out.println("test example " + out.charAt(digits));
        //d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
        int[] indexes = {1, 10, 100, 1000, 10000, 100000, 1000000};

        long expressionCalucalted = 1L;
        for (Integer index : indexes) {
            expressionCalucalted *= Integer.parseInt(out.charAt(index) + "");
        }


        System.out.println("total is :" + expressionCalucalted);

    }


}
