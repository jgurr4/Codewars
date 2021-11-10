package codeWarsJava;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FindOdd {

  //Return the number that appears an odd number of times.
  public static int findIt(int[] a) {
    final List<Integer> intList = Arrays.stream(a).boxed().collect(toList());
    final List<Integer> collect = intList.stream()
        .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
        .entrySet()
        .stream()
        .peek(System.out::println)
        .filter(e -> e.getValue() % 2 != 0)
        .peek(System.out::println)
        .map(e -> e.getKey())
        .peek(System.out::println)
        .collect(toList());
    return Integer.parseInt(collect.get(0).toString());
  }
}