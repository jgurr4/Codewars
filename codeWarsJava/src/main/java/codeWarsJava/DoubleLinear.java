package codeWarsJava;

import java.util.*;
import java.util.stream.Collectors;

//Don't forget to remove duplicates and sort the final result before you retrieve n.
// Both my solutions fail at the same spot. Which means there is a common trend between both.
// They both fail once n is higher than 6000. I have to figure out why that is.
public class DoubleLinear {
  static int max = 0;
  static int level = 0;

  public static int dblLinear(int n) {
    final TreeSet<Integer> numList = new TreeSet<Integer>();
    long start = System.currentTimeMillis();
    add(numList, 1, n);
    final Object[] arr = numList.toArray();
    long time = System.currentTimeMillis() - start;
    System.out.println("Time took: " + time);
//    System.out.println(Arrays.toString(arr));
    return (int) arr[n];
  }

  private static void add(TreeSet<Integer> numList, int i, int n) {
    if (numList.size() < n + 1 || max > i) {
      int x = 1 << level;
      level++;
      max = i > max ? i : max;
      numList.add(i);
      if (x < n*3) {       //FIXME: Right now this is just a guess as to how deep I have to go, I should try and figure out a way to make it solved with more exactness and not have to go so far over the required number of values.
        add(numList, 2 * i + 1, n);
        add(numList, 3 * i + 1, n);
      }
      level--;
      return;
    }
    numList.add(i);
    return;
  }

}

/*
      1 second = 1,000,000,000 nanoseconds.
      1 milisecond = 1,000,000 nanoseconds
      1 second = 1,000 miliseconds.
*/
// I also want to try and solve this kata using Java Streams.

/*
// This solutions works up to a certain limit. Anything above 6000 for n gets the number wrong.
public class DoubleLinear {
  static List<Integer> subListB = new ArrayList<Integer>();
  final static TreeSet<Integer> list = new TreeSet<Integer>();
  final static List<Integer> result = new ArrayList<Integer>();

  public static int dblLinear(int n) {
    System.out.println("n is: " + n);
    long start = System.nanoTime();
    list.clear();
    result.clear();
    subListB.clear();
    list.add(1);
    subListB.add(1);
    addSet(subListB, n);
    result.addAll(list);
    long time = System.nanoTime() - start;
    System.out.println("Time took: " + time);
    System.out.println("result is: " + result.get(n));
    return result.get(n);
  }

  public static void addSet(List<Integer> subListA, int n) {
    while (list.size() < n*2) {
      subListB = new ArrayList<>();
      for (int i = 0; i < subListA.size(); i++) {
        subListB.add(2 * subListA.get(i) + 1);
        subListB.add(3 * subListA.get(i) + 1);
      }
      subListB = subListB.stream().sorted().distinct().collect(Collectors.toList());
      list.addAll(subListB);
      addSet(subListB, n);
    }
    return;
  }

}
*/

/*
// This method is attempting to do what Jerm was advising by using recursion and doing shallow and deep searches.
public class DoubleLinear {
  static int max = 0;

  public static int dblLinear(int n) {
    final TreeSet<Integer> numList = new TreeSet<Integer>();
    add(numList, 1, n);
    final Object[] arr = numList.toArray();
    System.out.println(Arrays.toString(arr));
    return (int) arr[n];
  }

  private static void add(TreeSet<Integer> numList, int i, int n) {
    if (numList.size() < n + 1 || max > i) {
      max = i > max ? i : max;
      numList.add(i);
      add(numList, 2 * i + 1, n);   // I need to somehow make this do a shallow search first,
      add(numList, 3 * i + 1, n);   // then I do a shallow search here. And after both searches I have to do deep searches on both again.
    }
    return;
  }

}
*/

/* This was my attempt at using TreeSet in the method. I couldn't quite figure it out
public class DoubleLinear {
  final int setSize = 0;
  final static HashMap<Integer, TreeSet<Integer>> map = new HashMap<Integer, TreeSet<Integer>>(){};
  final static ArrayList<Object> result = new ArrayList<Object>();

  public static int dblLinear(int n) {
    final TreeSet<Integer> numList = new TreeSet<Integer>(){};
    long start = System.nanoTime();
    retrieveSet(n, 1);
    long time = System.nanoTime() - start;
    // Retrieve the value at index n inside result arraylist.
    return (int) result.get(n);
  }

  private static void retrieveSet(int n, int setNum) {
   // Steps
   // Retrieve second set from 1 and autosort/remove duplicates using treeset.
   // Retrieve more sets untile total set size is higher than n.
    TreeSet<Integer> numList = map.get(setNum);
    if (n > result.size()) {
      final Object[] arr = numList.toArray();
      for (int i = 0; i < numList.size(); i++) {
        map.put(i+2, {(2 * (int)arr[i] + 1), (3* (int) arr[i] + 1)});
        result.add(map.get(i+1).toArray());
      }
    }
  }

}
*/

/*
public class DoubleLinear {
  public static int dblLinear (int n) {
    int[] arr = new int[n];
    int x = 1;
    arr[0] = 1;
    arr[1] = (2 * x + 1);
    arr[2] = (3 * x + 1);
    for (int i = 1; i < arr.length + 10; i++) {
      x = arr[i];
      try {
        arr[i+2] = (2 * x + 1);
        arr[i+3] = (3 * x + 1);
        arr = Arrays.stream(arr).sorted().toArray();
      } catch (Exception e) {
        break;
      }
    }
    System.out.println(Arrays.toString(arr));
    final int result = arr[n-1];
    System.out.println("answer is: " + result);
    return result;
  }
}
*/

/*

//This was my most recent attempt using various Lists, and still trying to make recursion work.
  final static ArrayList<Integer> result = new ArrayList<Integer>();
  final static HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
  final static TreeSet<Integer> numList = new TreeSet<Integer>();
  public static int dblLinear(int n) {
    long start = System.nanoTime();
    retrieveSet(n, new int[]{1});
    long time = System.nanoTime() - start;
    System.out.println("Retrieved set in: " + time);
    return 0;
  }

  private static void retrieveSet(int n, int[] set) {
    List name = Arrays.asList(set);  //This is required since java requires you to intialize List first before use below.
    numList.addAll(name);
    if (n > result.size()) {
      for (int i = 0; i < numList.size(); i++) {
        map.put(i, set);
        result.add(2 * set[i] + 1);
        result.add(3 * set[i] + 1);
        retrieveSet(n, set);

      }
    }
  }
}
 */