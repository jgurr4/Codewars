package codeWarsJava;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class Snail {
  static int pos = 0;
  static int index = 1;

  public static int[] snail(int[][] array) {
    if (array.length == 1 && array[0].length == 0 || array[0].length == 1) {
      return array[0];
    }
    final int[] arr = Arrays.stream(array).flatMapToInt(x -> Arrays.stream(x)).toArray();
    final int colNum = array[0].length;
    final int rowNum = array.length;
    int[] visited = new int[arr.length];
    int[] solution = new int[arr.length];

    solution[0] = arr[pos];
    visited[0] = pos;
    while (solution[arr.length - 1] == 0) {
      checkRight(arr, colNum, rowNum, solution, visited);
      checkDown(arr, colNum, rowNum, solution, visited);
      checkLeft(arr, colNum, rowNum, solution, visited);
      checkUp(arr, colNum, rowNum, solution, visited);
    }
    System.out.println(Arrays.toString(solution));
    pos = 0;
    index = 1;
    return solution;
  }

  private static void checkUp(int[] arr, int colNum, int rowNum, int[] solution, int[] visited) {
    for (int i = 1; i < rowNum; i++) {
      if (!beenVisited(pos - colNum, visited)) {
        pos -= colNum;
        visited[index] = pos;
        solution[index] = arr[pos];
        index++;
      }
    }
  }

  private static void checkLeft(int[] arr, int colNum, int rowNum, int[] solution, int[] visited) {
    for (int i = colNum; i > 0; i--) {
      if (!beenVisited(pos - 1, visited)) {
        pos--;
        visited[index] = pos;
        solution[index] = arr[pos];
        index++;
      }
    }
  }

  private static void checkDown(int[] arr, int colNum, int rowNum, int[] solution, int[] visited) {
    for (int i = 1; i < rowNum; i++) {
      if (!beenVisited(pos + colNum, visited)) {
        pos += colNum;
        visited[index] = pos;
        solution[index] = arr[pos];
        index++;
      }
    }
  }

  private static void checkRight(int[] arr, int colNum, int rowNum, int[] solution, int[] visited) {
    for (int i = 1; i < colNum; i++) {
      if (!beenVisited(pos + 1, visited)) {
        pos++;
        visited[index] = pos;
        solution[index] = arr[pos];
        index++;
      }
    }
  }

  private static boolean beenVisited(int nextPos, int[] visited) {
    IntPredicate intPredicate = x -> { if (x == nextPos) { return true; } return false; };
    if(nextPos < 0 || nextPos > visited.length) {
      return true;
    }
    if (Arrays.stream(visited).anyMatch(intPredicate)) {
      return true;
    }
    return false;
  }
}

/* Remove this if I succeed above.
    while (!goalReached) {
      for (int i = 0; i < arr.length; i++) {
        for (int j = 1; j <= rowNum; j++) {
          while (pos < colNum * j) {
            if (!beenVisited(pos + 1) && validSpace(pos + 1)) {
              pos++;
              solution[i] = arr[pos];
            } else if (!beenVisited(pos + 1 * j) && validSpace(pos + 1 * j)) {
              pos += 1 * j;
              solution[i] = arr[pos];
            } else if (!beenVisited(pos - 1) && validSpace(pos - 1)) {
              pos--;
              solution[i] = arr[pos];
            } else if (!beenVisited(pos - 1 * j) && validSpace(pos - 1 * j)) {
              pos -= 1 * j;
              solution[i] = arr[pos];
            } else {
              goalReached = true;
            }
          }
        }
      }
    }
    return solution;
  }

  private static boolean validSpace(int i) {
    return false;
  }

  private static boolean beenVisited(int i) {
    return false;
  }
}
*/
/*  This is a method I was trying to use for working with a two dimensional array.
public class Snail {
  public static int[] snail(int[][] array) {
//    final int[] singleArr = Arrays.stream(array).flatMapToInt(x -> Arrays.stream(x)).toArray();
    final int colNum = array[0].length;
    final int rowNum = array.length;
    final int totalLength = colNum * rowNum;
    int[] solution = {totalLength};
    int[] pos = {0, 0}; // {x, y} where x = colNum, and y = rowNum
    solution[0] = array[pos[0]][pos[1]];
    for (int i = 0; i < colNum; i++) {
      for (int j = 0; j < rowNum; j++) {
        boolean[][] visitedArr = new boolean[colNum][rowNum];
        boolean visited = visitedArr[i][j];
        if (pos[0] < colNum && visited == false) { // if there is room to move right, it moves position right.
          pos[0] += 1;
        }
        if (j != 0) {
          solution[i] = array[pos[0]][pos[1]];
        }
      }
    }
    return null;
  }
}
*/
