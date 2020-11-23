package ru.sbrf.cu.jmm;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterFixed {
  private AtomicInteger count = new AtomicInteger(0);
  private static final int LIMIT = 100_000_000;

  public static void main(String[] args) throws InterruptedException {
    CounterFixed counter = new CounterFixed();
    counter.go();
  }

  private void inc() {
    for (int i = 0; i < LIMIT; i++) {
      count.incrementAndGet();
    }
  }

  private void go() throws InterruptedException {
    Thread thread1 = new Thread(this::inc);
    Thread thread2 = new Thread(this::inc);
    Thread thread3 = new Thread(this::inc);

    thread1.start();
    thread2.start();
    thread3.start();

    thread1.join();
    thread2.join();
    thread3.join();
    System.out.println("CounterBroken:" + count);
  }
}

