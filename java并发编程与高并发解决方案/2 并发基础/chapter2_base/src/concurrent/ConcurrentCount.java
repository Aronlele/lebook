package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/**
 * 多线程并发计数器 - 错数版
 *
 * @author : 薛乐乐
 * @since : 2019/12/12 8:52
 */
public class ConcurrentCount {

  private static int count = 1;

  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();
    int threadTocal = 200;
    Semaphore semaphore = new Semaphore(threadTocal);
    int clientTotal = 5000;
    for (int i = 0; i < clientTotal; i++) {
      executor.execute(
          () -> {
            try {
              semaphore.acquire();
              count();
              semaphore.release();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
      );
    }
    executor.shutdown();
    System.out.println("当前总数：" + count);
  }

  private static void count() {
    count++;
  }

}
