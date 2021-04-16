package codeWarsJava;

public class Test {
  private static long gcd(long a, long b) {
    while (b > 0) {
      long temp = b;
      b = a % b; // % is remainder
      a = temp;
    }
    return a;
  }

  private static long gcd(long[] input) {
    long result = input[0];
    for (int i = 1; i < input.length; i++) result = gcd(result, input[i]);
    return result;
  }

  private static long lcm(long a, long b) {
    return a * (b / gcd(a, b));
  }

  private static long lcm(long[] input) {
    long result = input[0];
    for (int i = 1; i < input.length; i++) result = lcm(result, input[i]);
    return result;
  }
}
