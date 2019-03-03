package com.melnyk.task3;

public class Task3 {

  public void startTask3() {
    MyLock simpleLock = new MyLock();

    for (int i = 0; i < 5; i++) {
      new Thread(() -> {

        simpleLock.lock();
        start();
        simpleLock.unlock();

      }).start();
    }
  }

  private static void start() {
    System.out.println(Thread.currentThread());
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread());
  }
}
