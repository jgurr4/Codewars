package codeWarsJava;

import java.math.*;

public class Factorial {


  public static int getZeros(int n) {
    BigInteger currentNum = new BigInteger("" + (n));
    BigInteger factorial = BigInteger.valueOf(n);  //Alternative method to initialize. Doesn't require ""
    for (int i = 1; i < n - 1; i++) {
      currentNum = currentNum.subtract(BigInteger.valueOf(1));
      factorial = factorial.multiply(currentNum);
      System.out.println("factorial is: " + factorial +
          "\nn is: " + currentNum);

    }
    int counter = 0;
    while (factorial.mod(BigInteger.valueOf(10)).equals(BigInteger.valueOf(0))) {
      factorial = factorial.divide(BigInteger.valueOf(10));
      counter++;
      System.out.println("counter is: " + counter);
    }
    return counter;
  }
}
