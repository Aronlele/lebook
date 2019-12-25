package com.example.demo.test;

/**
 * 枚举 安全
 *
 * @author : 薛乐乐
 * @since : 2019/12/25 11:33
 */
public class SingleExample5 {

  //私有构造
  private SingleExample5() {

  }

  //工厂
  public static SingleExample5 SingleExample3Factory() {
    return SingleExampleEnum.INSTANCE.getInstance();
  }

  private enum SingleExampleEnum {
    INSTANCE;
    private  SingleExample5 singleExample5 = null;
    SingleExampleEnum(){
      singleExample5 = new SingleExample5();
    }
    SingleExample5 getInstance(){
      return singleExample5;
    }
  }
}
