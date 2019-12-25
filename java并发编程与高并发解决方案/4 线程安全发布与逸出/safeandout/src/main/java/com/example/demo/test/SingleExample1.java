package com.example.demo.test;

/**
 * 单例模式 饿汉模式
 *
 * @author : 薛乐乐
 * @since : 2019/12/25 11:30
 */
public class SingleExample1 {

  //私有构造
  private SingleExample1() {
  }

  private static SingleExample1 singleExample1 = new SingleExample1();

  //工厂方法
  public static SingleExample1 SingleExample1Factory(){
    return singleExample1;
  }

}
