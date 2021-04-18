package com.wumj.demo.java8interface;

/**
 * @author wumj
 * @date 2020-06-20 12:56
 */
public class SubClass implements Myfun ,MyInterface{


    @Override
    public String name() {
        return Myfun.super.name();
    }
}
