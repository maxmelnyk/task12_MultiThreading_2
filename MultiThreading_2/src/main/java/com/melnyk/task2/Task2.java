package com.melnyk.task2;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Task2 {

  private BlockingQueue<String> blockingQueue = new PriorityBlockingQueue();

  public void startTask7() {
    Thread writeThread = new Thread(this::writeSomething);
    Thread readThread = new Thread(this::readSomething);

    writeThread.start();
    readThread.start();

    try {
      writeThread.join();
      readThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void writeSomething() {
    try {
      Scanner myLine = new Scanner(System.in);
      String text;
      for (; ; ) {
        System.out.print("Write: ");
        text = myLine.nextLine();
        blockingQueue.add(text);
        if (text.equals("exit")) {
          System.exit(0);
        }
        Thread.sleep(10);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void readSomething() {
    try {
      for (; ; ) {
        String text = blockingQueue.take();
        System.out.println("Read: " + text);
        if (text.equals("exit")) {
          System.exit(0);
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
