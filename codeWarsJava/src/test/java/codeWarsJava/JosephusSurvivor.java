package codeWarsJava;

import java.util.ArrayList;
import java.util.stream.IntStream;

// Come back and try to finish this solution because I want to figure out the way to do it logically rather than just using
// a math formula with recursion. Check the answers on codewars to see how it can be done.
public class JosephusSurvivor {
  public static int josephusSurvivor(int n, int k) {
    ArrayList<Integer> nArr = new ArrayList<Integer>();
    int result = 0;
    //Create array of values with range 1-n. IntStream method:
    long start = System.currentTimeMillis();
    IntStream.rangeClosed(1, n).forEach(e -> nArr.add(e));  // 78 milliseconds to complete 1-1000000 range
    long time = System.currentTimeMillis() - start;
    System.out.println("range created in: " + time + " milliseconds.");
    System.out.println(nArr);
    int killed = 0;

    start = System.currentTimeMillis();
    for (int i = 1; i < n; i++) {
      killed = k * i % (n - i - 1) - 1;
      killed = killed < 0 ? 0 : killed;
      System.out.println("result is: " + nArr.get(killed));
      nArr.remove(killed);
    }
    time = System.currentTimeMillis() - start;
    System.out.println("Found survivor " + nArr.get(killed) + " in: " + time + " milliseconds.");
    return result;
  }
}
/*
//This solution works. But it is a little cheap because it's pure math with recursion. Since this is a bilinear search tree. This recursion is perfect for it.
  public static int josephusSurvivor(int n, int k) {
    System.out.println(n + " " + k);
    if (n == 1 || k == 1)
      return 1;
    else
      return (josephusSurvivor(n - 1, k) + k - 1) % n + 1;
  }
*/
