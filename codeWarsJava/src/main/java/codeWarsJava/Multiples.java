package codeWarsJava;

public class Multiples {
  public int sumOfMultiples(int n) {
    int sum = 0;
    if (n < 0) {
      return 0;
    }

    for (int i = 0; i < n; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }

    System.out.println(sum);
    return sum;
  }
}
