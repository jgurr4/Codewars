package codeWarsJava;

import java.util.*;

//Goal of this kata: Digital root is the recursive sum of all the digits in a number.
//Given n, take the sum of the digits of n. If that value has more than one digit, 
//continue reducing in this way until a single-digit number is produced.
//Examples:   16  -->  1 + 6 = 7          942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
public class DigitalRoot {
    public static int digital_root(int n) {
    	int result = sumdigit(n);
		
		while(result >= 10) {
			result = sumdigit(result);
		}
    	
        return result;
        
      
  }
   public static int sumdigit(int n) {
    	int newNum = 0;
    	List<Integer> numArr = new ArrayList<Integer>(n);    	

    	while(n > 0) {
    		numArr.add(n % 10);
    		n /= 10;
    	}

		for(int i : numArr ) {
			newNum += i;
		}
		return newNum;
   }
}
    	
// Study this and find out why it works, and remember to use this method in future to reduce code.
//public static int digital_root(int n) {
//    return (n != 0 && n%9 == 0) ? 9 : n % 9;
//  }

//This one is my favorite, I think it is a best practice that can apply to other things:
//  public static int digital_root(int n) {
//    while(n > 9){
//      n = n/10 + n % 10;
//      }
//    return(n);
//  }
