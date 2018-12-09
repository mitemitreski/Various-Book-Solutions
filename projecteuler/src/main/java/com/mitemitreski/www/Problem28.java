package com.mitemitreski.www;

import com.mitemitreski.www.EulerUtil;

/**
 * Spiral matirx fill
 */
public class Problem28 {
  enum Direction {
    DOWN, RIGHT, UP, LEFT;
  }

  //brute force
  public static void main(String[] args) {
    int N = 5;
    Integer[][] matrix = new Integer[N][N];
    //form a spiral
    EulerUtil.printMatix(matrix);
    int i = 0;
    int j = 0;
    int count = N * N;
    Direction direction = Direction.DOWN;
    while (i != N / 2 - 1 && j != N / 2 - 1) {
      matrix[i][j] = count;
      count++;
      if (direction == Direction.RIGHT) {
        i++;
      } else if (direction == Direction.DOWN) {
        j++;
      } else if (direction == Direction.LEFT) {
        i--;
      } else if (direction == Direction.UP) {
        j--;
      }

      //TODO not finished
    }

    System.out.println("----------------------------");

    EulerUtil.printMatix(matrix);
    //calculate diagonal


    int sum = 0;
  }

  private static Direction newDirection(Direction direction) {
    return direction;
  }
}
