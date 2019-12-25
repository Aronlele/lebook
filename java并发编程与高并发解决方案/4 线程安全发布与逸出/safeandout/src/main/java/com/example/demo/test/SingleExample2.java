package com.example.demo.test;

/**
 * 懒汉模式 安全
 *
 * @author : 薛乐乐
 * @since : 2019/12/25 11:33
 */
public class SingleExample2 {

  //私有构造
  private SingleExample2() {

  }

  //对象
  private static SingleExample2 singleExample2 = null;

  //工厂
  public static synchronized SingleExample2 SingleExample2Factory(){
    if (singleExample2 == null) {
      return singleExample2 = new SingleExample2();
    }
    return singleExample2;
  }

}
