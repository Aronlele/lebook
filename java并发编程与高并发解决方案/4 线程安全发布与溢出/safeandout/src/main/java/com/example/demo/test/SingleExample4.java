package com.example.demo.test;

/**
 * 懒汉模式 volatile关键字禁止指令重排可安全
 *
 * @author : 薛乐乐
 * @since : 2019/12/25 11:33
 */
public class SingleExample4 {

  //私有构造
  private SingleExample4() {

  }

  //对象
  private static volatile SingleExample4 singleExample3 = null;

  //工厂
  //1 memory 分配内存空间
  //2 instance = allocate memory 为实例指顶内存
  //3 初始化对象
  public static SingleExample4 SingleExample3Factory(){
    if (singleExample3 == null) {
      //双重验证
      synchronized (SingleExample4.class){
        if (singleExample3 == null) {
          return singleExample3 = new SingleExample4();
        }
      }
    }
    return singleExample3;
  }

}
