package com.example.demo.test;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * 不安全的线程发布.
 *
 * @author : 薛乐乐
 * @since : 2019/12/25 10:53
 */
@Slf4j
public class UnsafePublish {

  private String[] arrays = {"a", "b", "c"};

  public UnsafePublish() {
    log.info("now arrays:{}", Arrays.toString(this.arrays));
  }

  public static void main(String[] args) {
    UnsafePublish up = new UnsafePublish();
    up.arrays[0] = "d";
    log.info("after modify,arrays:{}", Arrays.toString(up.arrays));
  }

}
