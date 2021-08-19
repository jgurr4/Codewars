package codeWarsJava;

import javax.swing.text.DateFormatter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
    System.out.println("exponent is: " + pow); // 16
    //Alternatively I could use bitwise operator and then I wouldn't have to cast it at all.
    System.out.printf("$%4.2f %n", 22.03); // $22.03
    System.out.printf("%,d %n", 100000);  // 100,000
    System.out.printf("Hashcode for %s is: %h %n", "John", "John"); // Hashcode for John is: 15bt81b937t1
    Long n = 123124389515819L;
//    BigDecimal bigDec = 1.21134511234124313412431242345322;
    double bigDec = n / 1000000000000.0;
    System.out.println("BigDecimal is: " + bigDec); // 123.124389515819
    System.out.printf("Adding decimal to number is: %.2f %n", 123456f); // 123456.00
    float num = 123456f;
    DecimalFormat numFormat = new DecimalFormat("###.000");
    System.out.println("alternative add decimal is: " + numFormat.format(num)); // 123456.000 same as above, the number of digits before decimal is minimum not maximum.
    LocalDate date = LocalDate.now();
    System.out.printf("%1$tA, %1$tB %1$tm %1$tY %n", date);  // Wednesday, August 08 2021
    System.out.println("full date is: " + date);  // full date is: 2021-08-18
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
    // Is it immutable? Is it synchronized? Does it allow null values?
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

class Algorithms {
  public static void onDataStructures(){
    // Trees for sorting and binary search trees (divide and conquer)
    // merge sort and quick sort etc...
  }
}

class ThreadSafety {
  public static void wrapping() {
    /* source: https://www.baeldung.com/java-thread-safety
    // There are many ways to achieve thread-safety in Java. The most recommended ways is to use
    // Immutable classes/structures for your objects. Where that isn't possible, you have alternative methods:
    ThreadLocal           (Forces a object created to stay in the thread in which it was created.)
    Synchronization wrapper   (Waits until all threads have synced to the object state before moving on. It's basically the same as using 1 thread at a time, so you lose the benefit of multi-threaded processors.)
    asynchronous libraries/frameworks   (Has all the benefits of multi-threaded processors, with lower level synchronization to prevent objects being incorrect when read.)
    Java 8 Streams      (Allows operations because they don't change the original objects even if mutable.)
    Reactive Streams   (A combination of asynchronous libraries with java 8 Streams on steroids. It has all the benefits of )
    // Here are some examples of useful immutable and thread-safe classes:
    String
    Any primitive java type.
    Google Guava Immutable Collections  (Is a decent alternative to default java non-immutable and non-threadsafe collections).
    Making your own Immutable data structures.
    // The ultimate thread-safe setup would be using Reactive Streams library like RXJava with Immutable Data Structures
    // that either you made or the ones in Google Guava.
     */
    // Synchronized methods:
//    public synchronized void incrementCounter() {
//      counter += 1;
//    }
    // Synchronized operations:
    List<String> list = new ArrayList<>();
    synchronized (list) {
      //operations on list
       }
    // Synchronized Collections:
    Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
    Thread thread1 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
    Thread thread2 = new Thread(() -> syncCollection.addAll(Arrays.asList(7, 8, 9, 10, 11, 12)));
    thread1.start();
    thread2.start();
    // ThreadLocal: There are two ways to create a object with ThreadLocal:
    final ThreadLocal<ArrayList> al = new ThreadLocal<>();
    al.get().add("hello");
    al.get().get(0);
    final ThreadLocal<ArrayList> al2 = ThreadLocal.withInitial(() -> new ArrayList<String>());
    al2.get().add("initialExample");
    al2.get().get(0);
    // DateTime and DateTimeFormatter:
    // Classes in Java.time are designed to work with multi-threading. However, DateFormatter which is in
    // java.swing.text are not thread-safe. So if you must use them, you can use ThreadLocal to make them
    // thread-safe like so: Modern programmers will use classes like DateTimeFormatter found in java.time.
    // So you shouldn't ever be using the java.swing.text classes for this.
  }
}

