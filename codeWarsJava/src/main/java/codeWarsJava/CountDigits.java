package codeWarsJava;

/* Goal is to count the number of digits in a integer. Example: 2020 should return 4 digits.

 */
public class CountDigits {
  public static int countDigits(int n) {

    int answer = 0;
    while(n != 0) {
      answer++;
      n /= 10;
    }

    return answer;
  }
}

//Alternative to this is as follows:
/*
  return String.valueOf(n).length();
  //this converts int to a string and finds the length. This requires less code.
 */
