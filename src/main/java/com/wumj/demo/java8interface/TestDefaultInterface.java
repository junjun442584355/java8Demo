package com.wumj.demo.java8interface;

/**
 * @author wumj
 * @date 2020-06-20 12:59
 */
public class TestDefaultInterface{
    /*
    * 类优先原则
    * */
    public static void main(String[] args) {
        SubClass subClass=new SubClass();
        System.out.println(subClass.name());

        MyInterface.show();
    }
}
