package com.melnyk.task1;

import java.util.concurrent.locks.Lock;

public class MyLock {

  public void method1(Lock lock) {
    lock.lock();
    System.out.println(Thread.currentThread().getName() + " method1 is lock");
    lock.unlock();
    System.out.println(Thread.currentThread().getName() + " method1 is unlock");
  }

  public void method2(Lock lock) {
    lock.lock();
    System.out.println(Thread.currentThread().getName() + " method2 is lock");
    lock.unlock();
    System.out.println(Thread.currentThread().getName() + " method2 is unlock");
  }

  public void method3(Lock lock) {
    lock.lock();
    System.out.println(Thread.currentThread().getName() + " method3 is lock");
    lock.unlock();
    System.out.println(Thread.currentThread().getName() + " method3 is unlock");
  }
}
