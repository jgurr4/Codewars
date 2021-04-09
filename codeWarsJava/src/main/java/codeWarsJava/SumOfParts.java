package codeWarsJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfParts {
  public static int[] sumParts(int[] ls) {
    int[] result = new int[ls.length+1];
    for(int i = ls.length-1; i >= 0; --i) {
      result[i] = result[i+1] + ls[i];
    }
    System.out.println(Arrays.toString(result));  //Take this out of final solution.
    return result;
  }
}


/*
//This was my initial solution using two for loops. it passed all normal tests, but it failed in the performance test which had 150000 to 200000 length array inputs.
//The problem with this solution is that is uses nested for loops which while they do work, they are not optimal.
    public static int[] sumParts(int[] ls) {
        int[] temp = new int[ls.length + 1];
        int sum = 0;
        final int length = ls.length;
        for (int i = 0; i < length; i++) {
            for (int item : ls) {
                sum += item;
            }
            temp[i] = sum;
            ls = Arrays.copyOfRange(ls, 1, ls.length);
            sum = 0;
        }
        temp[length] = 0;
        System.out.println(Arrays.toString(temp));
        return temp;
    }



//Here was my second solution that used Java 8 Streams. It succeeded in all the tests, but still failed performance test.
    public static int[] sumParts(int[] ls) {
        final int length = ls.length;
        int[] result = new int[length + 1];
        for (int i = 0; i < length; i++) {
            int sum = IntStream.of(ls).sum();
            result[i] = sum;
            ls = Arrays.copyOfRange(ls, 1, length);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
*/