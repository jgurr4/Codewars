package codeWarsJava.algorithms;

/* https://www.geeksforgeeks.org/selection-sort/
For selectionSort if you take an array of numbers or letters with 6 values, find the minimum value, then swap that value with the first value in the index.
The first value is now untouchable, so now you just search the array from index 1-5. Now when you find a new minimum value of the rest of the values, swap it
with the first value in the unsorted values again, and now that becomes untouchable as well, so you now search from index 2-5, and repeat the process.
You can imagine them like two separate arrays. The first original array is slowly eaten by the new sorted array.
 */ // This works, next step is to make it work for strings or chars through ascii values I think.
// Also figure out what is utility of stable sorting algorithms vs. non-stable. https://www.geeksforgeeks.org/stable-selection-sort/
// To make Arrays work with any object so you don't have duplicate code for each one, just use generic arrays.
// ArrayLists are much easier to accept any object for sorting and return any object, because it already works with any object.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SelectionSort implements Comparator {
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

  public static char[] sort(char[] arr) {
    if (arr.length == 0) {
      System.out.println(Arrays.toString(arr));
      return arr;
    }
    char minNum = arr[0];
    int minIndex = 0;
    for (int j = 0; j < arr.length - 1; j++) {
      for (int i = j; i < arr.length; i++) {
        if (arr[i] < minNum) {
          minNum = arr[i];
          minIndex = i;
        }
      }
      arr[minIndex] = arr[j];
      arr[j] = minNum;
      minNum = arr[j + 1];
    }
    System.out.println(Arrays.toString(arr));
    return arr;
  }

  @Override
  public int compare(Object o1, Object o2) {
    return 0;
  }
}

// To do this, make a separate method inside if (arr[i] < min) called compare Strings, which will compare the first letters until it finds a
// difference, then the different letter is compared by it's ASCII value. For example john and jose both have same first two letters,
// so it skips those and only compares the first different letters, which is 'h' and 's'. So then it returns the smaller one, which in this case is 'h'
// so it returns 'john' first.
/*
  public static Object[] sort(Object[] arr) {
    ArrayList<Integer> test = new ArrayList<>();
    test.add(5);
    test.add(1);
    test.sort(new SelectionSort()); //How to make a comparable for .sort() method. implement in class itself so it is a comparable. Or make a separate comparable class that implements Comparator interface
    if (arr.length == 0) {
      System.out.println(Arrays.toString(arr));
      return arr;
    }
    String min = arr[0];
    int minIndex = 0;
    for (int j = 0; j < arr.length - 1; j++) {
      for (int i = j; i < arr.length; i++) {  // set i = j so the sorted values in beginning don't get altered.
        if (arr[i] < min) {
          min = arr[i];     // set min num equal to the smallest number found in list.
          minIndex = i;        // set min index equal to the location of the smallest number found in list.
        }
      }
      arr[minIndex] = arr[j];        // replace the position of min number with the value of first number in unsorted section of array.
      arr[j] = min;               // replace the first number in unsorted section of array with the min number.
      min = arr[j + 1];           // reset min to first number in remaining unsorted section of array.
    }
    System.out.println(Arrays.toString(arr));
    return arr;
  }
*/
