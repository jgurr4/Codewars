package codeWarsJava;

import java.util.*;
import java.util.regex.*;

public class Finder {
  static int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  static int[] exit = new int[2];
  static List<int[]> visited = new ArrayList<>();
  static char[][] mazeArr;

  static boolean pathFinder(String maze) {
    List<int[]> test = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      test.add(new int[]{0, i});
    }
    Pattern pattern = Pattern.compile("\n");
    Matcher matcher = pattern.matcher(maze);
    int row = ((int) matcher.results().count() + 1);
    int col = maze.substring(0, maze.indexOf("\n")).length();  //FIXME: If there is only one row without \n it won't count that line so it will be 0 rows.
    exit[0] = row - 1;
    exit[1] = col - 1;
    mazeArr = new char[row][col];
    maze = maze.replace("\n", "");
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        mazeArr[i][j] = maze.substring(i * col, i * col + col).charAt(j);
      }
    }
    System.out.println(Arrays.deepToString(mazeArr));
    int[] pos = coordinate(0, 0);
    visit(pos);
    List<int[]> path = new ArrayList<>();
    path.add(pos);
    Boolean result = check(maze, path);
    return result;
  }

  public static Boolean check(String maze, List<int[]> path) {
    if (path.get(path.size() - 1)[0] != exit[0] && path.get(path.size() - 1)[1] != exit[1]) {
      for (int[] direction : DIRECTIONS) {
        int[] nextPos = coordinate(direction[0] + path.get(path.size() - 1)[0], direction[1] + path.get(path.size() - 1)[1]);
        if (valid(nextPos) && !wall(nextPos) && !beenVisited(nextPos)) {
          path.add(nextPos);
          System.out.print(Arrays.toString(path.get(path.size() - 1)));
          visit(nextPos);
          return check(maze, path);
        }
      }
      if (path.size() != 0) {
        path.remove(path.size() - 1);
        return check(maze, path);
      } else {
        return false;
      }
    }
    return true;
  }

  private static int[] coordinate(int x, int y) {
    return new int[]{x, y};
  }

  private static boolean beenVisited(int[] nextPos) {
    for (int i = 0; i < visited.size(); i++) {
      if (visited.get(i)[0] == nextPos[0] && visited.get(i)[1] == nextPos[1]) {
        return true;
      }
    }
    return false;
  }

  private static void visit(int[] pos) {
    visited.add(pos);
  }

  private static boolean valid(int[] pos) {
    if (pos[0] < 0 || pos[1] < 0 || pos[0] > mazeArr.length - 1 || pos[1] > mazeArr[0].length - 1) {
      return false;
    }
    return true;
  }

  private static boolean wall(int[] pos) {
    if (mazeArr[pos[0]][pos[1]] == 'W') {
      return true;
    }
    return false;
  }
}



/*
//this method turns it into a nested char[][].
    Pattern pattern = Pattern.compile("\n");
    Matcher matcher = pattern.matcher(maze);
    long matches = matcher.results().count() + 1;   // Need to add 1 to result because last row doesn't end with \n.
    int row = ((int) matches);                                 // Retrieves number of row.
    int col = maze.substring(0, maze.indexOf("\n")).length();  // Retrieves number of columns
    char[][] mazeArr = new char[row][col];     // Creates two dimensional mazeArray.
    System.out.println(Arrays.deepToString(mazeArr));
    String noNewLines = maze.replace("\n", "");
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        mazeArr[i][j] = noNewLines.substring(i*col, i*col + col).charAt(j);
      }
      System.out.println(Arrays.deepToString(mazeArr));
    }
    // Use a method here to determine if a path can be taken from top left corner to bottom right corner.

    return false;
  }
}
*/


/*
    String[] mazeArr = maze.split("\n");
    int row = mazeArr[0].length();  //Retrieves number of rows.
    int col = mazeArr.length;       //Retrieves number of columns.
    int[] position = new int[]{row, col};
    int[] lastPos = new int[]{row, col};
    String lastMove = "";
    int timesVisited = 0;
    for (int i = row-1; i > 0; i--) {
      for (int j = col-1; j > 0; j--) {
        char c = mazeArr[i].charAt(j);
        if (i == row && j == col) {
          continue;                  //skip the first char loop.
        }
        if (mazeArr[i - 1].charAt(j) == '.') {   //Check if space below is empty.  Always check down first,
          lastPos[0] = position[0];
          position[0] -= 1;                      //moves player down one.
          lastMove = "south";
        } else if (mazeArr[i].charAt(j - 1) == '.') {   //Check if space to the right is empty.
          lastPos[1] = position[1];
          position[1] -= 1;                   //moves player right one.
          lastMove = "east";
        } else if (i != row) {                               // Checks if any space exists above.
          if (mazeArr[i + 1].charAt(j) == '.') {   //Check if space above is empty.
            lastPos[0] = position[0];
            position[0] += 1;                      //moves player up one.
            lastMove = "north";
          }
        } else if (j != col) {                       // Checks if any space exists to the left.
          if (mazeArr[i].charAt(j + 1) == '.') {   //Check if space to the left is empty.
            lastPos[1] = position[1];
            position[1] += 1;                      //moves player left one.
            lastMove = "west";
          }
        }
        System.out.println("new position is: " + Arrays.toString(position));
        System.out.println("last position was: " + Arrays.toString(lastPos));
      }
    }
    return false;
  }
}
*/
/*
    for (int i = 0; i < numberOfRows; i++) {
        String row = maze.substring(i, maze.indexOf("\n"));
        int rowLength = row.length();
        String[] row = new String[rowLength];
        i += rowLength;
        }

 */
/*
  private int[] getNextCoordinate(
          int row, int col, int i, int j) {
    return new int[]{row + i, col + j};
  }
*/
/*
// This method works with the string as is, but splits it into a one dimensional array to work with.
public class Finder {
   boolean pathFinder(String maze) {
    String[] mazeArr = maze.split("\n");
    int rows = mazeArr[0].length();  //Retrieves number of rows.
    int cols = mazeArr.length;       //Retrieves number of columns.
    for (String s : mazeArr) {
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
      }
    }
    return false;
  }
}
*/
