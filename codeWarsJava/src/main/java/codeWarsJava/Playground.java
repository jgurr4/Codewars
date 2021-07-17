package codeWarsJava;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.*;
import java.util.Date;

public class Playground {
  public static final double percent = 30.5;
  public static int totalRuns;
  private int height;
  private int num1;
  private int num2;

  public int getNum1() {
    return num1;
  }

  public void setNum1(int num1) {
    this.num1 = num1;
  }

  public int getNum2() {
    return num2;
  }

  public void setNum2(int num2) {
    this.num2 = num2;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public Playground() {
    totalRuns++;       //Doesn't use this because it's a static variable.
    this.height++;     //Requires this because it's a intantiated variable that is applicable only to this created object.
    this.setNum1(4);
  }

  public int exponent(int a, int b) {
    final int pow = (int) Math.pow(a, b); // I cast as int because otherwise it returns double.
    //Alternatively I could use bitwise operator and then I wouldn't have to cast it at all.
    System.out.printf("$%4.2f %n", 22.03);
    System.out.printf("%,d %n", 100000);
    System.out.printf("Hashcode for %s is: %h %n", "John", "John");
    Long n = 123124389515819L;
//    BigDecimal bigDec = 1.21134511234124313412431242345322;
    double bigDec = n / 1000000000000.0;
    System.out.println("BigDecimal is: " + bigDec);
    System.out.printf("Adding decimal to number is: %2.2f %n", 123456f);
    float num = 123456f;
    DecimalFormat numFormat = new DecimalFormat("###.000");
    System.out.println("alternative add decimal is: " + numFormat.format(num));
    System.out.println("exponent is: " + pow);
    LocalDate date = LocalDate.now();
    System.out.printf("%1$tA, %1$tB %1$tm %1$tY %n", date);
    System.out.println("full date is: " + date);
    return pow;
  }

  public static int modulo(int a, int b) {
    final int result = a % b;
    System.out.println("Modulo result = " + result);
    int maxNum = 1;
    int minNum = 20000;
//    for (int i = 0; i < 100; i++) {
//    long myRandom = (long) (Math.random() * ((maxNum - minNum) + 1));  //This is the way to do random if you want large whole numbers instead of a double.
//    System.out.println("Random number is: " + myRandom);
//    }
    return result;
  }
  static class Something {    //Nested Class.
    public static int multiply(int a, int b) {
      final int result = a*b;
      System.out.println("Multiply result = " + result);
      return result;
    }
  }
}

class MorePlay extends Playground {
  public static int divide(int a, int b) {
    final int result = a / b;
    System.out.println("Divide result = " + result);
    return result;
  }
}
