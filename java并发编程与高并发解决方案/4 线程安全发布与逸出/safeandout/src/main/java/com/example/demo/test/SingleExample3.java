package com.example.demo.test;

/**
 * 懒汉模式 不安全
 *
 * @author : 薛乐乐
 * @since : 2019/12/25 11:33
 */
public class SingleExample3 {

  //私有构造
  private SingleExample3() {

  }

  //对象
  private static SingleExample3 singleExample3 = null;

  //工厂
  //1 memory 分配内存空间
  //2 instance = allocate memory 为实例指顶内存
  //3 初始化对象
  //jvm cpu指令重排， 2,3顺序不一定，导致，线程可能使用未初始化的对象
  public static  SingleExample3 SingleExample3Factory(){
    if (singleExample3 == null) {
      //双重验证
      synchronized (SingleExample3.class){
        if (singleExample3 == null) {
          return singleExample3 = new SingleExample3();
        }
      }
    }
    return singleExample3;
  }

}
