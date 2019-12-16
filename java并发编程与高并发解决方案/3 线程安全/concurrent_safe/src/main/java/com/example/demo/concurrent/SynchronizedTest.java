package com.example.demo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : 薛乐乐
 * @since : 2019/12/16 16:19
 */
@Slf4j
public class SynchronizedTest {

  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();
    SynchronizedTest service1 = new SynchronizedTest();
    SynchronizedTest service2 = new SynchronizedTest();
    executor.execute(() -> {
      service1.test2(1);
    });
    executor.execute(() -> {
      service2.test2(2);
    });
  }

  public void test1(int j) {
    synchronized (this) {
      for (int i = 0; i < 10; i++) {
        log.info("test1 {} - {}", j, i);
      }
    }
  }

  public synchronized void test2(int j) {
    for (int i = 0; i < 10; i++) {
      log.info("test2 {} - {}", j, i);
    }
  }

}
