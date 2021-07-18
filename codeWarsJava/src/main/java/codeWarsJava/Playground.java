package codeWarsJava;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.*;
import java.util.*;


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

class DataStructures {

  public static void collections() {
    // Questions to ask before using a linear data structure:
    // Is it immutable? Is it thread-safe/synchronized? Does it allow null values?
    // How fast are its main operations in Big O Notation compared to other data structures?
    // Is it self-resizing or in other words Dynamic? Is it ordered or retain insertion order?
    // Is it self-sorting?
    // You can get these answers by looking at the source code or documentation of each class.
    // Big O Levels:  --> https://stackoverflow.com/questions/2307283/what-does-olog-n-mean-exactly
    // Fastest: O(1)      Constant
    // Faster: O(log(n))  Variable   //For example, Hash classes are like this for lookup, because you don't need to search through all the names of phonebook you just use divide and conquer strategy to find what subsection (alphabet letter section) their name is in, then search through that list to find their name.
    // Fast: O(n)         Linear
    // Slowest: O(n^2)    Quadratic

    char[] ca = {'a', 'b', 'c'};             // Simple array. Allows index lookup

    // List and implementations:  Lists are resizable and typically keep their input order.
    ArrayList al = new ArrayList();          // Resizable array and works with iterator.
    Vector v = new Vector();                 // Synchronized/thread-safe alternative to ArrayList.
    Iterator<String> iter = al.iterator();   // Iterator is superior replacement to Enumeration. Since it allows .remove during iteration and shorter method names.
    while (iter.hasNext()) {                       // Example looping through ArrayList using iterator.
      iter.next();
    }

    //Stack/Deque/Queue and List implementations:
    LinkedList ll = new LinkedList();  // Useful for faster adding and removing values vs ArrayList, since doesn't need to shift all values. Also implements stack and queue methods through deque interface.
    ArrayDeque ar = new ArrayDeque();  // Better than LinkedList for Queues, Better than Stack for Stacks.

    // Set implementations:  Sets don't contain duplicates.
    HashSet<String> hs = new HashSet<>();  // Faster at search lookup than normal arrays. Un-ordered.
    LinkedHashSet<Object> lhs = new LinkedHashSet<>();  // Ordered.
    TreeSet<String> ts = new TreeSet<>();  // Self-sorted and no-duplicates linear data structure. Useful when you need to sort for every element added to the structure.

    // Map implemenations:   Maps are key-value arrays. Dictionary is similar because it is the grandfather of all key-value pair classes.
    HashMap<String, Integer> hm = new HashMap<>();  // Un-ordered entries
    Hashtable<String, Integer> ht = new Hashtable<String, Integer>();  // synchronized version of hashmap that doesn't permit nulls. Synchronized means thread-safe by default.
    LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();   // ordered entries.
    TreeMap<String, Integer> tm = new TreeMap<>();  // sorted by key.

//    method examples:
    Collections.sort(al); // Collections methods are useful to perform generic operations on collections classes.
    Collections.synchronizedList(al);  // A way to make ArrayList synchronized. Also you can do .synchronizedSet or Map as well.
    Arrays.toString(ca);  // Arrays class also has useful methods to perform on Java Arrays. But not collections.
    Arrays.sort(ca);


  }
}

class algorithms {
  public static void onDataStructures(){
    // Trees for sorting and binary search trees (divide and conquer)
    // merge sort and quick sort etc...
  }

}

