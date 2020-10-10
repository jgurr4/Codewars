package codeWarsJava;

import java.util.*;

public class SqInRect2 {
  public static List<Integer> sqInRect(int l, int w) {
    
    if(l == w) return null; //Makes sure we never use this function on perfect squares, only on rect
    
    ArrayList<Integer> answer = new ArrayList<Integer>();
    int smallInt = Math.min(l, w);
    int bigInt = Math.max(l, w);
    int temp = 0;
    
    while(bigInt >= 1) {
      temp = smallInt;
      smallInt = Math.min(smallInt, bigInt);
      bigInt = Math.max(bigInt, temp);
      answer.add(smallInt);
      bigInt -= smallInt;
    }

    return answer;
  }
}

/* The goal of this Kata was to fill the dimensions of a perfect rectangle with perfect squares.
 * I found out the simplest way of doing this is to repeatedly subtract the smaller dimension from
 * the larger dimension until both are equal to 1, and the value for the smaller dimension of each
 * set is one of the entries for the answer. For example: 
 * W:12 L:7    W:5 L:7    W:5 L:2    W:3 L:2    W:1 L:2    W:1 L:1  Answer = [7, 5, 2, 2, 1, 1]
 *   12-7=5      7-5=2      5-2=3    3-2=1       2-1=1       1-1=0
 * This will always return perfect squares inside that perfectly fill the perfect rectangles. 
 * As long as you square each of those entries. so 7^2 5^2 2^2 2^2 1^2 1^2  Since 1^1 = 1x1 = 1 
 * it still works. Now my goal is to make a method that accomplishes what I showed above.
 */