package codeWarsJava;

/*
This method illustrates the basics of working with threads.
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadedCounting {
  static AtomicInteger latest;
  public static class Count extends Thread {
    private int start;
    private Counter counter;

    public Count(int start, Counter counter) {
      this.start = start;
      this.counter = counter;
    }

    @Override
    public void run() {
      for (int i = this.start; i <= 100; )
        if (latest.get() == i) {
          this.counter.count(i);
          i += 3;
          latest.getAndIncrement();
        }
    }
  }
  public static void countInThreads(Counter counter) {
    Count t1 = new Count(1, counter);
    Count t2 = new Count(2, counter);
    Count t3 = new Count(3, counter);
    latest = new AtomicInteger(1);
    try {
      t1.start();
      t2.start();
      t3.start();

      t1.join();
      t2.join();
      t3.join();
    } catch (InterruptedException ex) {};
  }
}
*/

/*
This method illustrates how to use Executors in a useful way. This is my preferred method.
This method works nicely because instead of needing to make a new class extending Thread, this just makes an array of executors, then
uses logic to choose one of those executor threads in order to run the same task when it is appropriate for that thread to run
it. Executors are useful to learn because they can return futures and use callables, so they can be asynchronous.
 */
import java.util.concurrent.*;
public class ThreadedCounting {
  public static void countInThreads(Counter counter) {
    ExecutorService[] execs = new ExecutorService[3];
    for (int i = 0; i < 3; i++) {
      execs[i] = Executors.newSingleThreadExecutor();
    }
    try {
      for (int i = 1; i <= 100; i++) {
        int n = i;
        Runnable task = () -> counter.count(n);
        execs[n % 3].submit(task).get();
      }
      for (int i = 0; i < 3; i++) {
        execs[i].shutdown();
        execs[i].awaitTermination(1, TimeUnit.SECONDS);
      }
    } catch (InterruptedException | ExecutionException e) {
      throw new Error("can't happen", e);
    }
  }
}
