package com.example.demo.concurrent;
import	java.util.concurrent.Semaphore;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : 薛乐乐
 * @since : 2019/12/13 18:38
 */
@Slf4j
public class ConcurrentTest {

  private static int clientTotal = 5000;
  private static int threadTotal = 200;
  private static int count = 0;
  private static AtomicInteger atomicInteger = new AtomicInteger();

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newCachedThreadPool();
    Semaphore semaphore = new Semaphore(threadTotal);
    CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
    for (int i = 0; i < clientTotal; i++) {
      executor.execute(
          () -> {
            countDownLatch.countDown();
            try {
              semaphore.acquire();
            } catch (InterruptedException e) {
              log.error("exception: {}", e);
            }
            count();
            semaphore.release();
          }
      );
    }
    countDownLatch.await();
    executor.shutdown();
    log.info("count: {}", atomicInteger);
  }

  private static void count() {
    atomicInteger.incrementAndGet();
  }

}
