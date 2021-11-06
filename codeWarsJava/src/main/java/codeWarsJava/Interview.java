package codeWarsJava;


import java.util.ArrayList;
import java.util.Arrays;

public class Interview {
  public Integer[] returnNormal(int[][] arrays) {
    // Add them to ArrayList, then convert ArrayList to array and that's it.
    final int[][] intArr = {{1, 2, 3}, {1, 2, 3}};
    final int[] newArr;
    final ArrayList<Integer> arrList = new ArrayList<>();
    for (int i = 0; i < arrays[0].length; i++) {
      arrList.add(arrays[0][i]);
    }
    for (int i = 0; i < arrays[1].length; i++) {
      arrList.add(arrays[1][i]);
    }

    return (Integer[]) arrList.toArray();
  }


  public void printCombo(int[] arr, int target) {
    //combo and the position in array.
    // {1, 3, 2, 4} target: 7.
    if(target == arr[0] + arr[1]) {
      System.out.println(arr[0] + ":" + 0);
      System.out.println(arr[1] + ":" + 1);
    }
    for (int i = 0; i-1 < arr.length; i++) {
      if(target == arr[i] + arr[i+1]) {
        // Use recursion here to make this work.
        System.out.println(arr[i] + ":" + i);
      }
    }
  }



}
