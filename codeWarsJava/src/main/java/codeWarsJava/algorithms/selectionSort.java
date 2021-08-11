package codeWarsJava.algorithms;

/* https://www.geeksforgeeks.org/selection-sort/
For selectionSort if you take an array of numbers or letters with 6 values, find the minimum value, then swap that value with the first value in the index.
The first value is now untouchable, so now you just search the array from index 1-5. Now when you find a new minimum value of the rest of the values, swap it
with the first value in the unsorted values again, and now that becomes untouchable as well, so you now search from index 2-5, and repeat the process.
You can imagine them like two separate arrays. The first original array is slowly eaten by the new sorted array.
 */ // This works, next step is to make it work for strings or chars through ascii values I think.
// Also figure out what is utility of stable sorting algorithms vs. non-stable. https://www.geeksforgeeks.org/stable-selection-sort/

import java.util.Arrays;

public class selectionSort {
  public static int[] sort(int[] arr) {
    if (arr.length == 0) {
      System.out.println(Arrays.toString(arr));
      return arr;
    }
    int minNum = arr[0];
    int minIndex = 0;
    for (int j = 0; j < arr.length - 1; j++) {
      for (int i = j; i < arr.length; i++) {  // set i = j so the sorted values in beginning don't get altered.
        if (arr[i] < minNum) {
          minNum = arr[i];     // set min num equal to the smallest number found in list.
          minIndex = i;        // set min index equal to the location of the smallest number found in list.
        }
      }
      arr[minIndex] = arr[j];        // replace the position of min number with the value of first number in unsorted section of array.
      arr[j] = minNum;               // replace the first number in unsorted section of array with the min number.
      minNum = arr[j + 1];           // reset minNum to first number in remaining unsorted section of array.
    }
    System.out.println(Arrays.toString(arr));
    return arr;
  }
}
