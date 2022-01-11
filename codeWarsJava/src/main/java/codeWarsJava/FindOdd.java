package codeWarsJava;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

// Check out the answers for this kata to see a awesome use of XOR ^ operator.
  // https://www.codewars.com/kata/54da5a58ea159efa38000836/solutions/java
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