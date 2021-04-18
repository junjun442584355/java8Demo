package com.wumj.demo.java8interface;

/**
 * @author wumj
 * @date 2020-06-20 13:02
 */
public interface MyInterface {
    default String name(){
        return "myinterface";
    }

    public static void show(){
        System.out.println("我是接口myinterface中的静态方法");
    }
}
