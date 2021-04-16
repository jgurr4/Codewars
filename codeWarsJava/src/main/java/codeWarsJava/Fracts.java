package codeWarsJava;


import java.util.Arrays;
import java.util.stream.LongStream;

// The goal of this kata is to receive a nested array of integers which represents a numerator and denominator. You are tasked
// with converting all the fractions to the same denominator and making that denominator as small as possible while still making sure the numerators are converted correctly.
// For example: { {1, 2}, {1, 3}, {10, 40} } should return (6,12)(4,12)(3,12)
public class Fracts {
  public static String convertFrac(long[][] lst) {
    long[] denomArr = new long[lst.length];
    // Check if the given array has values first. So this program doesn't have an error if that happens.
    String result = "";
    if (lst.length < 1) {
      return result;
    }
    int gcd = 0;
    System.out.println("input is: " + Arrays.deepToString(lst));
    System.out.println("total numbers is: " + lst.length * 2);


    // loop through the array to pull out each numerator and denominator.
    for (int i = 0; i < lst.length; i++) {
      denomArr[i] = lst[i][1];
      // reduce/simplify any fractions that can be reduced.
      if (lst[i][0] > 1) {
        for (int e = 0; e <= denomArr[i] && e <= lst[i][0]; e++) {
          if ((double) lst[i][0] % e == 0 && (double) denomArr[i] % e == 0) {
            gcd = e;
          }
        }
        lst[i][1] = denomArr[i] / gcd;
        denomArr[i] = denomArr[i] / gcd;
        lst[i][0] /= gcd;
      }
      System.out.println("reduced fractions are: " + lst[i][0] + ", " + denomArr[i]);
    }
    // sort the denominators. It doesn't matter if the order gets mixed up from numerator,
    // because all denominators are going to become the same number eventually.
    long[] sortedArr = LongStream.of(denomArr).sorted().toArray();
    // obtain the largest denominator in the list to use as prospective common denominator.
    long commonDenom = LongStream.of(denomArr).max().getAsLong();
    // set oldlargest which will keep the original largest number saved in case it has to change.
    long oldLargest = commonDenom;

    // loop through the denominators and check if they are all able to go into the largest denominator.
    // If not, increase largest denominator and loop again from beginning.
    int e = 2;
    for (int i = 1; i <= lst.length; i++) {
      if (((double) commonDenom % sortedArr[lst.length - i]) != 0) {
        commonDenom = oldLargest * e;
        i = 0;
        e++;
      }
    }
    // set common denominator for all the denominators.
    for (int i = 0; i < lst.length; i++) {
      // Multiply each numerator with the number of times the original denominator goes into the common denominator.
      lst[i][0] *= (commonDenom / lst[i][1]);
      // set each denominator equal to the common denominator.
      lst[i][1] = commonDenom;
    }
    // convert completed value of lst to a string.
    result = Arrays.deepToString(lst)
            .replaceAll("^\\[", "")
            .replaceAll("]$", "")
            .replace("[", "(")
            .replace("]", ")")
            .replace("), ", ")")
            .replace(", ", ",");
    return result;
  }
}
