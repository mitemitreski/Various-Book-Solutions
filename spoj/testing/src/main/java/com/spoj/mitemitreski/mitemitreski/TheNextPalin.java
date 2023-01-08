package com.spoj.mitemitreski.mitemitreski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheNextPalin {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            int[] lineNumbers = getStringToNumArray(line);

            if (isAll9(lineNumbers)) {
                System.out.println("1" + "0".repeat(line.length() - 1) + "1");
            } else {
                int midIndex = lineNumbers.length / 2;
                int leftIndex = midIndex - 1;
                boolean isOddLength = lineNumbers.length % 2 == 1;
                int rightIndex = isOddLength ? midIndex + 1 : midIndex;

                boolean smallerLeft = false;

                //while same compare till end
                while (leftIndex >= 0 && lineNumbers[leftIndex] == lineNumbers[rightIndex]) {
                    leftIndex--;
                    rightIndex++;
                }

                if (leftIndex < 0 || lineNumbers[leftIndex] < lineNumbers[rightIndex]) {
                    smallerLeft = true;
                }

                if (smallerLeft) {
                    midIndex = lineNumbers.length / 2;
                    leftIndex = midIndex - 1;
                    int carry = 1;

                    if (isOddLength) {
                        lineNumbers[midIndex] += carry;
                        carry = lineNumbers[midIndex] / 10;
                        lineNumbers[midIndex] %= 10;
                        rightIndex = midIndex + 1;

                    } else {
                        rightIndex = midIndex;
                    }

                    while (leftIndex >= 0) {
                        lineNumbers[leftIndex] += carry;
                        carry = lineNumbers[leftIndex] / 10;
                        lineNumbers[leftIndex] %= 10;
                        lineNumbers[rightIndex++] = lineNumbers[leftIndex--];
                    }

                } else {
                    while (leftIndex >= 0) {
                        //mirror left to roght
                        lineNumbers[rightIndex++] = lineNumbers[leftIndex--];
                    }
                }

                printArray(lineNumbers);
            }

        }

    }



    /*
11
9
99
808
2133
2322
2144
12345678987654322
1234567887654322
1239222
1230222
3210123

11
101
818
2222
2332
2222
12345679097654321
1234567997654321
1239321
1230321
3211123
    */

    public static boolean isAll9(int[] numberList) {
        for (int num : numberList) {
            if (num != 9) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] numberList) {
        for (int num : numberList) {
            System.out.print(num);
        }
        System.out.println();
    }

    public static int[] getStringToNumArray(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        return arr;

    }
}