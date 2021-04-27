package codeWarsJava;

import javax.swing.*;
import java.io.PrintStream;
import java.util.Arrays;

//Arrays.sort(), Arrays.join() and logic foreach, and regex pattern, matcher, string.replaceAll, and printf method:
//This solution took me 1 hour and 22 min.
public class RangeExtraction {
  public static String rangeExtraction(int[] arr) {
    Arrays.sort(arr);
    String result = "";
    for (int i = 0; i < arr.length; i++) {
      if (arr.length > i + 2) {
        if (arr[i + 1] == Math.incrementExact(arr[i]) && arr[i + 2] == Math.incrementExact(arr[i + 1])) {  //checks if the value of current 3 elements is a range.
          int rangeLength = checkRangeLength(arr, i);    //if they are a range, determine how long the range goes.
          result += String.format(",%d-%d", arr[i], arr[i + rangeLength]); //Add values to string replace values within the range with a range.
          i += rangeLength;     //set i to value past the end of range that we already processed.
        } else {
          result += String.format(",%d", arr[i]);
        }
      } else {
        result += String.format(",%d", arr[i]);
      }
    }
    result = result.replaceAll("^,", "");
    return result;
  }

  public static int checkRangeLength(int[] arr, int i) {
    int length = 0;
    while (arr[i] == Math.decrementExact(arr[i + 1])) { //Checks if previous value is equal to current value.
      i++;
      length++;     //increment length value as many times as this loop is run.
      if (i + 1 == arr.length && arr[i - 1] == Math.decrementExact(arr[i])) {
        break;
      }
    }
    return length;
  }
}

/*
//StringBuilder method (I didn't make this one, but I want to try this myself when I get a chance):
class Solution {
    public static String rangeExtraction(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            int j = i;
            while (j < arr.length - 1 && arr[j] + 1 == arr[j + 1]) j++;
            if (i + 1 < j) {
                i = j;
                sb.append("-");
                sb.append(arr[i]);
            }
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
*/
//Streams method:
/*
    Arrays.stream(arr).sorted().forEachOrdered(x -> x > y ? );
*/
