package codeWarsJava;

import java.util.*;
import java.util.stream.*;
import java.util.stream.IntStream.Builder;

/*Note: This is saved as an example how to use non-static methods and share variables.
 * It isn't as good as the other SqInRect2 class, but I will try to get this to work and do same thing.
 */
//Goal of this codewar: When given the length and width of a true rectangle, create a algorithm that
//automatically splits it into perfect squares. You will return an array or a string with the size 
//of each of the squares.
//For example a rectangle with a width of 5 and length
//of 3 SqInRect(5, 3) should return [ 3, 2, 1, 1 ] you only need one dimension because they are perfect squares. 
//so that 3 actually means 3x3, same with 2, and 1. 
public class SqInRect {
  ArrayList<Integer> answer;
  
  public void sqInRect(int l, int w) {
    answer = new ArrayList<Integer>();
    int smallInt = (l < w)? l : w;
    int bigInt = (l > w)? l : w;
    int rem = bigInt%smallInt;
    int divis = bigInt/smallInt;
    
    if(rem == 0) {
      addToList(smallInt, divis);   //add smallInt divis number of times.
    } else if(rem == 1){
      addToList(smallInt, divis);   //add smallInt divis number of times.
      addToList(1, smallInt);       //add 1 smallInt number of times.
    } else {
      addToList(smallInt, divis);   //add smallInt, divis number of times.
      if(smallInt%2 != 0) {
        addToList(2, smallInt/2);   //add 2 smallInt/2 number of times.
        addToList(1, 2);            //add 1 two times.
      } else {
        addToList(2, smallInt/2);   //add 2 smallInt/2 number of times.
      }
    }
    System.out.println(answer);
  }
  
  public void addToList(int n, int n2) {
    int i = 0;
    while(i < n2) {
      answer.add(n);
      i++;
    }
    
  }
  
}


//Right now my problem with this code is that I need a way to make addToList() add a specific 
//value a specific number of times. But with .add() you can only add one item at a time, or you can
//do a collection, but having to do a collection each time seems like too much repetitive code. 
//I'll try and see if there is a way to do this with streams and IntStream to make it accomplish the
//task without making me repeat myself.

/* Patterns I learned from this problem:
 * 1: if both given dimensions are odd = odd number of squares. If one is even = even number of sq.
 * 2: smaller dimension provided can always be first accepted #. Bigger dimension will always be
 * too large to be accepted, and anything larger than smaller dimension will also be too large. 
 * 3: True rectangle is always 2 different dimensions provided, so you'll never have (2, 2) since that is a square.
 * 4: remainder of big dimension / small dimension will determine how the rectangle can be filled.
 *    -> if b%s = 0 then small dimension can fill entire thing.
 *    -> if b%s = 1 then small dimension can fill most, then one's fill rest.
 *      -> the number of times smallInt fills is determined by how many times it goes into big int.
 *      -> the number of 1's is determined by how many times 1 goes into the small int, 
 *      in other words, 1xsmallint is how many ones fills the rest.
 *    -> if b%s = 2 then small dimension can fill most, then one's and/or two's fill rest.
 *      -> the number of 2's is determined by how many times 2 goes into the small int. 
 *      if the small int is even, there will be no ones.
 *      -> if the small int is odd, the number of 1's is always going to be 2 for this scenario.
 *    -> if b%s > 2 I need to find out what happens.
 */
//      IntStream.range(0, divis).forEach(i -> addToList(smallInt));
//    IntStream.range(0, divis).forEach(i -> System.out.println(String.join("", Collections.nCopies(i+1, "" + divis + ""))));
//    IntStream stream = IntStream.of(smallInt, divis, 1, 2);