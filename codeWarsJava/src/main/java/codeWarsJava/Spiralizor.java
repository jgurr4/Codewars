package codeWarsJava;
public class Spiralizor {

  public static int[][] spiralize(int size) {
    int[][] spiral = new int[size][size];
    int barrier = size;
    Direction currentDir = Direction.RIGHT;
    Boolean rightIsValid, downIsValid, leftIsValid, upIsValid;
    for (int i = 0; i < size * size; i++) {
      switch (currentDir) {
        case RIGHT -> {
          rightIsValid = checkRightValidity(spiral, barrier, i);
          downIsValid = checkDownValidity(spiral, barrier, i);
          if (rightIsValid) {
            spiral[i / 5][i % 5 + 1] = 1;
          } else if (downIsValid){
            currentDir = Direction.DOWN;
            i--;
          } else {
            return spiral;
          }
        }
        case DOWN -> {
          downIsValid = checkDownValidity(spiral, barrier, i);
          leftIsValid = checkLeftValidity(spiral, barrier, i);
          if (downIsValid) {
            spiral[i / 5 + 1][i % 5] = 1;
          } else if (leftIsValid){
            currentDir = Direction.LEFT;
            i--;
          } else {
            return spiral;
          }
        }
        case LEFT -> {
          leftIsValid = checkLeftValidity(spiral, barrier, i);
          upIsValid = checkUpValidity(spiral, barrier, i);
          if (leftIsValid) {
            spiral[i / 5][i % 5 - 1] = 1;
          } else if (upIsValid){
            currentDir = Direction.UP;
            i--;
          } else {
            return spiral;
          }
        }
        case UP -> {
          upIsValid = checkUpValidity(spiral, barrier, i);
          rightIsValid = checkRightValidity(spiral, barrier, i);
          if (upIsValid) {
            spiral[i / 5 - 1][i % 5] = 1;
          } else if (rightIsValid){
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

  private static Boolean checkUpValidity(int[][] spiral, int barrier, int i) {
    if (i/5 >= 0) {
      if (spiral[i/5-1][i%5] == 0 && spiral[i/5][i%5+2] != 1) {
        return true;
      }
    }
    return false;
  }

  private static Boolean checkLeftValidity(int[][] spiral, int barrier, int i) {
    if (i%5 >= 0) {
      if (spiral[i/5-1][i%5 - 1] == 0 && spiral[i/5][i%5+2] != 1) {
        return true;
      }
    }
    return false;
  }

  private static Boolean checkDownValidity(int[][] spiral, int barrier, int i) {
    if (i/5 <= barrier) {
      if (spiral[i/5-1][i%5] == 0 && spiral[i/5][i%5+2] != 1) {
        return true;
      }
    }
    return false;
  }

  private static Boolean checkRightValidity(int[][] spiral, int barrier, int i) {
    if (i%5 <= barrier) {
      if (spiral[i/5-1][i%5] == 0 && spiral[i/5][i%5+2] != 1) {
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