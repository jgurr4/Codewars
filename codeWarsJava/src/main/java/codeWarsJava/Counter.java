package codeWarsJava;

import java.util.Arrays;

public class Counter {
  public int[] values;

  public void count(int i) {
    int[] newArr = Arrays.copyOf(values, values.length+1);
    for (int j = 0; j < values.length+1; j++) {
      if (j >= values.length) {
        newArr[j] = i;
      }
      newArr[j] = values[j];
    }
  }
}
