package com.projecteurler.mitemitreski.www;

import static com.projecteurler.mitemitreski.www.Problem28.Direction.*;

/**
 * Spiral matirx fill
 */
public class Problem28 {
    enum Direction {
        DOWN, RIGHT, UP, LEFT;

        public final Direction next() {
            if (this == RIGHT) return DOWN;
            if (this == DOWN) return LEFT;
            if (this == LEFT) return UP;
            if (this == UP) return RIGHT;
            return this;
        }
    }

    //brute force
    public static void main(String[] args) {
        int N = 1001;
        int maxNumber = N * N;
        int[][] matrix = new int[N ][N ];
        int count = 2;
        int i = N / 2;
        int j = (N / 2) + 1;
        matrix[N / 2][N / 2] = 1;

        int currentSpiralLength = 1;
        Direction currentDirecton = DOWN;
        while (count <= maxNumber) {
            int lenthLeftToWrite = currentSpiralLength;
            while (lenthLeftToWrite-- > 0) {
                matrix[i][j] = count;
                count++;
                if (currentDirecton == RIGHT) {
                    j++;
                } else if (currentDirecton == DOWN) {
                    i++;
                } else if (currentDirecton == LEFT) {
                    j--;
                } else if (currentDirecton == UP) {
                    i--;
                }
//                EulerUtil.printMatix(matrix);
//                System.out.println("--------- ");
//                System.out.println("count=" + count + "||" + currentDirecton + "|| current spiral=" + currentSpiralLength);
//                System.out.println("--------- ");
            }
            currentDirecton = currentDirecton.next();
            if (currentDirecton == LEFT || currentDirecton == RIGHT) currentSpiralLength++;


//            EulerUtil.printMatix(matrix);
//            System.out.println("---NEXT turn------ ");
//            System.out.println("count=" + count + "||" + currentDirecton + "|| current spiral=" + currentSpiralLength);
//            System.out.println("---NEXT------ ");

        }

        EulerUtil.printMatix(matrix);
        //calculate diagonal


        int sum = 0;
        for (int x = 0; x < N; x++) {
            //left diagonal
            sum += matrix[x][x];
            //right diagonal
            sum+=matrix[x][N-x-1];
        }
        //
        sum-=1;


        System.out.println("The sum is " + sum);
    }

    private static Direction newDirection(Direction direction) {
        return direction;
    }
}
