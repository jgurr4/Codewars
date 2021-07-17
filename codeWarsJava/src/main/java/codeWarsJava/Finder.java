package codeWarsJava;

import java.util.*;

// The goal of this kata is simply to find out if the bottom right corner of a given maze can be reached from the
// top left corner.
// This method keeps string as it is, but determines the number of columns and uses that to gauge location.
public class Finder {
  static String newMaze;
  static char[] mazeArr;
  static Boolean goalReached;
  static Boolean noMoreSpace;
  static int rowNum;
  static int colNum;

  public static boolean pathFinder(String maze) {
    rowNum = 1;
    colNum = maze.indexOf('\n') > -1 ? maze.indexOf('\n') : maze.length();
    goalReached = false;
    noMoreSpace = false;
    Boolean hasOnlyOneRow = maze.indexOf('\n') == -1 ? true : false;
    Boolean firstRowHasW = maze.substring(0, colNum).indexOf('W') == -1 ? false : true;
    if (hasOnlyOneRow && firstRowHasW) {
      System.out.println("There is only one row and cannot reach end.");
      return false;
    } else if (hasOnlyOneRow) {
      System.out.println("There is only one row and end is reachable.");
      return true;
    }

    newMaze = maze;
    while (!hasOnlyOneRow) {
      rowNum++;
      newMaze = newMaze.replaceFirst("\n", "");  // This might be an inneficient way to replace \n, because it creates a new string for each \n. But as long as there are not thousands of rows it shouldn't be that big of a deal. However, if there is, then I'll need to use some other method to get the rows. And just replace all \n at once.
      hasOnlyOneRow = newMaze.indexOf('\n') == -1 ? true : false;
    }
    mazeArr = newMaze.toCharArray();

    int currentPos = 0;
    long start = System.currentTimeMillis();
    Boolean goalReached = solve(currentPos);
    long time = System.currentTimeMillis() - start;
    System.out.println("Time took: " + time);

    // This code is simply for testing purposes. Remove for finalized kata.
    maze = Arrays.toString(mazeArr).replace("[", "").replace(",", "").replace(" ", "");
    for (int i = 0; i < rowNum; i++) {
      System.out.println(maze.substring(colNum * i, colNum * i + colNum));
    }
    System.out.println("Can reach exit: " + goalReached + "\n");
    return goalReached;
  }

  private static Boolean solve(int position) {
    mazeArr[position] = 'x';
    goalReached = mazeArr[mazeArr.length - 1] == 'x' ? true : false;
    if (!goalReached) { //&& !noMoreSpace
      if (checkRight(mazeArr, position, colNum)) {
        position += 1;
        solve(position);
        if (!goalReached && noMoreSpace) {
          position -= 1;
          noMoreSpace = false;
        }
      }
      if (checkDown(mazeArr, position, colNum)) {
        position += colNum;
        solve(position);
        if (!goalReached && noMoreSpace) {
          position -= colNum;
          noMoreSpace = false;
        }
      }
      if (checkLeft(mazeArr, position, colNum)) {
        position -= 1;
        solve(position);
        if (!goalReached && noMoreSpace) {
          position += 1;
          noMoreSpace = false;
        }
      }
      if (checkUp(mazeArr, position, colNum)) {
        position -= colNum;
        solve(position);
      } else {
        noMoreSpace = true;
      }
    }
    return goalReached;
  }


  private static boolean checkRight(char[] mazeArr, int currentPos, int colNum) {
    if (currentPos + 1 < mazeArr.length) {
      return mazeArr[currentPos + 1] == '.' && currentPos % colNum != colNum - 1;
    }
    return false;
  }

  private static boolean checkLeft(char[] mazeArr, int currentPos, int colNum) {
    if (currentPos - 1 > 0) {
      return mazeArr[currentPos - 1] == '.' && currentPos % colNum != 0;
    }
    return false;
  }

  private static boolean checkDown(char[] mazeArr, int currentPos, int colNum) {
    if (currentPos + colNum < mazeArr.length) {
      return mazeArr[currentPos + colNum] == '.';
    }
    return false;
  }

  private static boolean checkUp(char[] mazeArr, int currentPos, int colNum) {
    if (currentPos - colNum > 0) {
      return mazeArr[currentPos - colNum] == '.';
    }
    return false;
  }

}

/* Reserved in case I need this original version again.
  private Boolean Solve(String maze, int colNum, char[] mazeArr) {
    int currentPos = 0;
    Boolean goalReached = false;
    Boolean noMoreSpace = false;
    while (!goalReached && !noMoreSpace) {
      mazeArr[currentPos] = 'x';
      if (mazeArr[currentPos + 1] == '.' && currentPos % colNum != colNum - 1) {   // Second condition checks to make sure there are cells to the right of current position for the current row.
        currentPos += 1;
      } else if (checkDown(mazeArr, currentPos, colNum)) {
        currentPos += colNum;
      } else if (mazeArr[currentPos - 1] == '.' && currentPos % colNum != 0) {   // Second condition checks to make sure there are cells to the left of current position for the current row.
        currentPos -= 1;
      } else if (checkUp(mazeArr, currentPos, colNum)) {
        currentPos -= colNum;
      } else {
        noMoreSpace = true;
      }
      goalReached = currentPos == maze.length() - 1 ? true : false;
    }
    return goalReached;
  }
*/
// Currently this cannot handle hitting a wall that it has to go up to pass. It is made to try going right and down which will cause it to inevitably make a circle around and block itself.
// Currently this cannot handle deadends where 3 of the sides are walls. Since it cannot go backwards.
// My plan is to make it recursively go back the same path it went down removing each x, until it finds another
// path that it didn't already go down, and attempt to go down it, until it either finds another dead end or the goal.
// For each dead end it will repeat this until every space has been used.


/* this method turns it into a two dimensional char array.
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
*/



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
