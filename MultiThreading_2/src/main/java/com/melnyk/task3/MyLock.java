package com.melnyk.task3;

public class MyLock {

  private int lockHoldCount;

  private long threadId;

  public MyLock() {
    lockHoldCount = 0;
  }

  public synchronized void lock() {
    if (lockHoldCount == 0) {
      lockHoldCount++;
      threadId = Thread.currentThread().getId();
    } else if (lockHoldCount > 0
        && threadId == Thread.currentThread().getId()) {
      lockHoldCount++;
    } else {
      try {
        wait();
        lockHoldCount++;
        threadId = Thread.currentThread().getId();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public synchronized void unlock() {
    if (lockHoldCount == 0) {
      throw new IllegalMonitorStateException();
    }
    lockHoldCount--;

    if (lockHoldCount == 0) {
      notify();
    }
  }
}
