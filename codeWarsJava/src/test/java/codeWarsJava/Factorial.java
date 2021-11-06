package codeWarsJava;

import java.math.*;

public class Factorial {


  public static int getZeros(int n) {
    BigInteger factorial = new BigInteger("" + n);
    BigInteger bigInt = new BigInteger("" + (n));
    for (int i = 1; i < n - 1; i++) {
      bigInt = bigInt.subtract(new BigInteger("1"));
      factorial = factorial.multiply(bigInt);
      System.out.println("factorial is: " + factorial +
          "\nn is: " + bigInt);

    }
    int counter = 0;
    while (factorial.mod(new BigInteger("10")).equals(new BigInteger("0"))) {
      factorial = factorial.divide(new BigInteger("10"));
      counter++;
      System.out.println("counter is: " + counter);
    }
    return counter;
  }
}
