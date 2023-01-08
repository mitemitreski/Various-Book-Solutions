package com.spoj.mitemitreski.mitemitreski.ILD18MSM;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/*

Input:
aab
baa

Output:
1

Input:
aaaaabaaa
aaaaaabaa

Output:
1


Input:
aabaaaaa
aaaaaabaa

Output:
1


Input:
baaaaaaa
aaaaaaab

Output:
1


Input:
baaaaaaa
aaaaaaba

Output:
2
 */

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String a = r.readLine();
        String b = r.readLine();


        if (a.equals(b)) {
            System.out.println(0);
            return;
        }

        int output = caluclateNumbeOfMoves(a, b);

        System.out.println(output);
    }

    public static int caluclateNumbeOfMoves(String a, String b) {
        int numberOfMoves = 0;
        for (int i = 0; i < a.length(); i++) {
            int j = i;
            int countMoves = 0;
            while (j < b.length() && a.charAt(i) != b.charAt(j)) {
                j++;
                countMoves++;
            }
            if (countMoves > a.length() / 2) {
                countMoves = a.length() / 2;
            }
            numberOfMoves += countMoves;

        }
        throw new RuntimeException("not solved");
//        int output = numberOfMoves / 2;
//        return output;

    }
}
