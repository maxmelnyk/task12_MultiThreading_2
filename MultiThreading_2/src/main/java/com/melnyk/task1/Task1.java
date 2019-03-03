package com.melnyk.task1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task1 {


  public void startWithOneLock() throws InterruptedException {
    System.out.println("      ---One Lock---");
    MyLock myLock = new MyLock();

    Lock lock = new ReentrantLock();

    startAndJoinThread(new Thread(() -> myLock.method1(lock)),
        new Thread(() -> myLock.method2(lock)),
        new Thread(() -> myLock.method3(lock)));
  }

  public void startWithDifferentLock() throws InterruptedException {
    System.out.println("      ---Different Lock---");
    MyLock myLock = new MyLock();

    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    Lock lock3 = new ReentrantLock();

    startAndJoinThread(new Thread(() -> myLock.method1(lock1)),
        new Thread(() -> myLock.method2(lock2)),
        new Thread(() -> myLock.method3(lock3)));
  }

  private void startAndJoinThread(Thread thread0, Thread thread1, Thread thread2)
      throws InterruptedException {
    thread0.start();
    thread1.start();
    thread2.start();

    thread0.join();
    thread1.join();
    thread2.join();
  }
}
