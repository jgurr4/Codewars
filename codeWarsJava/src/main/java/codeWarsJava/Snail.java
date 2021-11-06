package codeWarsJava;

import java.util.Arrays;

// Right now this fails to pass all the kata tests.
public class Snail {
  public static int[] snail(int[][] arr) {
    int rowNum = arr.length;
    int colNum = arr[0].length;
    int[] currentPosition = {0, 0};
    int[] nextPosition = {0, 0};
    int[][] visitedArr = new int[rowNum * colNum][2];
    int[] results = new int[rowNum * colNum];
    boolean visited = false;
    Direction currentDirection = Direction.right;

    for (int i = 0; i < rowNum * colNum; i++) {
      if (i > 0) {
        if (Arrays.equals(visitedArr[i - 1], currentPosition)) {
          i--;
        }
      }
      visitedArr[i] = new int[]{currentPosition[0], currentPosition[1]};
      visited = false;
      nextPosition = new int[]{currentPosition[0], currentPosition[1] + 1};
      if (currentDirection == Direction.right) {
        if (nextPosition[1] < colNum) {
          for (int j = 0; j < visitedArr.length; j++) {
            if (nextPosition[0] == visitedArr[j][0] && nextPosition[1] == visitedArr[j][1]) {
              visited = true;
              break;
            }
          }
        }
        if (visited == false && nextPosition[1] < colNum) {
          currentPosition[0] = nextPosition[0];
          currentPosition[1] = nextPosition[1];
          continue;
        } else {
          currentDirection = Direction.down;
        }
      }
      visited = false;
      nextPosition = new int[]{currentPosition[0] + 1, currentPosition[1]};
      if (currentDirection == Direction.down) {
        if (nextPosition[0] < rowNum) {
          for (int j = 0; j < visitedArr.length; j++) {
            if (nextPosition[0] == visitedArr[j][0] && nextPosition[1] == visitedArr[j][1]) {
              visited = true;
              break;
            }
          }
        }
        if (visited == false && nextPosition[0] < rowNum) {
          currentPosition[0] = nextPosition[0];
          currentPosition[1] = nextPosition[1];
          continue;
        } else {
          currentDirection = Direction.left;
        }
      }
      visited = false;
      nextPosition = new int[]{currentPosition[0], currentPosition[1] - 1};
      if (currentDirection == Direction.left) {
        if (nextPosition[1] >= 0) {
          for (int j = 0; j < visitedArr.length; j++) {
            if (nextPosition[0] == visitedArr[j][0] && nextPosition[1] == visitedArr[j][1]) {
              visited = true;
              break;
            }
          }
        }
        if (visited == false && nextPosition[1] >= 0) {
          currentPosition[0] = nextPosition[0];
          currentPosition[1] = nextPosition[1];
          continue;
        } else {
          currentDirection = Direction.up;
        }
      }
      visited = false;
      nextPosition = new int[]{currentPosition[0] - 1, currentPosition[1]};
      if (currentDirection == Direction.up) {
        if (nextPosition[0] >= 0) {
          for (int j = 0; j < visitedArr.length; j++) {
            if (nextPosition[0] == visitedArr[j][0] && nextPosition[1] == visitedArr[j][1]) {
              visited = true;
              break;
            }
          }
        }
        if (visited == false && currentDirection == Direction.up) {
          currentPosition[0] = nextPosition[0];
          currentPosition[1] = nextPosition[1];
          continue;
        } else {
          currentDirection = Direction.right;
          continue;
        }
      }
      break;
    }
    visitedArr[visitedArr.length - 1] = new int[]{currentPosition[0], currentPosition[1]};
    for (int i = 0; i < visitedArr.length; i++) {
      results[i] = arr[visitedArr[i][0]][visitedArr[i][1]];
    }
    System.out.println(Arrays.toString(results) + "\n");
    return results;
  }

  public enum Direction {
    right,
    down,
    left,
    up
  }

}

/*
public class Snail {

    public static int[] snail(int[][] arr) {
        int rowNum = arr.length;
        int colNum = arr[0].length;
//        int[] nextPosition = makeCoordinate(0, 0);
        int[] currentPosition = {0, 0};
        int[] nextPosition = {0, 0};
        int[][] visited = new int[rowNum*colNum][2];
        visited[0][0] = nextPosition[0];
        visited[0][1] = nextPosition[1];
        return null;
    }

    public static int[] makeCoordinate(int x, int y) {
        int[] coordinate = new int[2];
        coordinate[0] = x;
        coordinate[1] = y;
        return coordinate;
    }

}
*/

/*
public class Snail {

    public static int[] snail(int[][] arr) {
        int rowNum = arr.length;
        int colNum = arr[0].length;
        Coordinate pos = new Coordinate(0, 1);
        Coordinate[] visited = new Coordinate[rowNum * colNum];
        visited[0] = new Coordinate(0, 1);
        int[] posCoordinates = visited[0].getCoordinates();
        if (visited[i].getCoordinates() == nextPos) {
        }
        return null;
    }

    public static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int[] getCoordinates() {
            int[] arr = new int[2];
            arr[0] = this.x;
            arr[1] = this.y;
            return arr;
        }
    }
}
*/

/* This code works and passes the kata.
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
*/