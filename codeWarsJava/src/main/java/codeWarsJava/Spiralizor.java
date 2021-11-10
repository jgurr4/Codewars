package codeWarsJava;

import java.util.Arrays;

//FIXME: Finish later. It's a level 3 kata.
public class Spiralizor {

  public static int[][] spiralize(int size) {
    int[][] spiral = new int[size][size];
    spiral[0][0] = 1;
    int wallLength = size;
    Direction currentDir = Direction.RIGHT;
    Boolean rightIsValid, downIsValid, leftIsValid, upIsValid;
    for (int i = 0; i < size * size; i++) {
      switch (currentDir) {
        case RIGHT -> {
          rightIsValid = checkRightValidity(spiral, wallLength, i);
          downIsValid = checkDownValidity(spiral, wallLength, i);
          if (rightIsValid) {
            spiral[i / wallLength][i % wallLength + 1] = 1;
          } else if (downIsValid) {
            currentDir = Direction.DOWN;
            i--;
          } else {
            return spiral;
          }
        }
        case DOWN -> {
          downIsValid = checkDownValidity(spiral, wallLength, i);
          leftIsValid = checkLeftValidity(spiral, wallLength, i);
          if (downIsValid) {
            spiral[i / wallLength + 1][(wallLength-1) - i % wallLength] = 1;  //FIXME:
          } else if (leftIsValid) {
            currentDir = Direction.LEFT;
            i--;
          } else {
            return spiral;
          }
        }
        case LEFT -> {
          leftIsValid = checkLeftValidity(spiral, wallLength, i);
          upIsValid = checkUpValidity(spiral, wallLength, i);
          if (leftIsValid) {
            spiral[i / wallLength][i % wallLength - 1] = 1;
          } else if (upIsValid) {
            currentDir = Direction.UP;
            i--;
          } else {
            return spiral;
          }
        }
        case UP -> {
          upIsValid = checkUpValidity(spiral, wallLength, i);
          rightIsValid = checkRightValidity(spiral, wallLength, i);
          if (upIsValid) {
            spiral[i / wallLength - 1][i % wallLength] = 1;
          } else if (rightIsValid) {
            currentDir = Direction.RIGHT;
            i--;
          } else {
            return spiral;
          }
        }
      }
    }
    return spiral;
  }

  private static Boolean checkUpValidity(int[][] spiral, int wallLength, int i) {
    if (i / wallLength - 1 >= 0) { // Check if a wall exists in goal space.
      if (i / wallLength - 2 >= 0) { // Check if a wall exists next to goal space.
        if (spiral[i / wallLength - 2][i % wallLength] != 1) { // Check if non-wall space beyond current goal is empty.
          return true;
        } else {
          return false;
        }
      } else if (spiral[i / wallLength - 1][i % wallLength] == 0) { //Check if space next to wall is empty.
        return true;
      }
    }
    return false;
/*
    if (i / wallLength >= 0) {
      if (spiral[i / wallLength + 1][i % wallLength] == 0 && spiral[i / wallLength + 2][i % wallLength] != 1) {
        return true;
      }
    }
    return false;
*/
  }

  private static Boolean checkLeftValidity(int[][] spiral, int wallLength, int i) {
    if (i % wallLength - 1 >= 0) { // Check if a wall exists in goal space.
      if (i % wallLength - 2 >= 0) { // Check if a wall exists next to goal space.
        if (spiral[i / wallLength][i % wallLength - 2] != 1) { // Check if non-wall space beyond current goal is empty.
          return true;
        } else {
          return false;
        }
      } else if (spiral[i / wallLength][i % wallLength - 1] == 0) { //Check if space next to wall is empty.
        return true;
      }
    }
    return false;
/*
    if (i % wallLength >= 0) {
      if (spiral[i / wallLength][i % wallLength - 1] == 0 && spiral[i / wallLength][i % wallLength - 2] != 1) {
        return true;
      }
    }
    return false;
*/
  }

  private static Boolean checkDownValidity(int[][] spiral, int wallLength, int i) {
    if (i / wallLength + 1 < wallLength) { // Check if a wall exists in goal space.
      if (i / wallLength + 2 < wallLength) { // Check if a wall exists next to goal space.
        if (spiral[i / wallLength + 2][i % wallLength] != 1) { // Check if non-wall space beyond current goal is empty.
          return true;
        } else {
          return false;
        }
      } else if (spiral[i / wallLength + 1][i % wallLength] == 0) { //Check if space next to wall is empty.
        return true;
      }
    }
    return false;
  }

  private static Boolean checkRightValidity(int[][] spiral, int wallLength, int i) {
    if (i % wallLength + 1 < wallLength) { // Check if a wall exists in goal space.
      if (i % wallLength + 2 < wallLength) { // Check if a wall exists next to goal space.
        if (spiral[i / wallLength][i % wallLength + 2] != 1) { // Check if non-wall space beyond current goal is empty.
          return true;
        } else {
          return false;
        }
      } else if (spiral[i / wallLength][i % wallLength + 1] == 0) { //Check if space next to wall is empty.
        return true;
      }
    }
    return false;
  }

  public enum Direction {
    RIGHT,
    DOWN,
    LEFT,
    UP
  }

}