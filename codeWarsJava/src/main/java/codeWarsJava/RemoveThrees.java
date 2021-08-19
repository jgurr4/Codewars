package codeWarsJava;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveThrees {
/*
//With ArrayList:
    public static String removeThrees(int[] arr) {
      ArrayList<Integer> newArr = new ArrayList<>();
      for (int i = 0; i < arr.length; i++) {
        if(arr[i] != 3) {
          newArr.add(arr[i]);
        }
      }
      return newArr.toString();
    }
*/
// Without ArrayList:
  public static String removeThrees(int[] arr) {
    int skipped = 0;
    int size = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 3) {
        size++;
      }
    }
    final int[] newArr = new int[size];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 3) {
        newArr[i - skipped] = arr[i];
      } else {
        skipped++;
      }
    }
    System.out.println(Arrays.toString(newArr));
    return Arrays.toString(newArr);
  }
}
