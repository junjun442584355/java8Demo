package com.wumj.demo.lambda.lambdaDemo2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author wumj
 * @date 2020-06-18 22:16
 */

/*
*
* java8内置的4大核心函数式接口
*
* consumer<T> :消费型接口
*   void  accept(T t);
*
* supplier<T> :供给型接口
*    T get();
*
* function<T,R>:函数型接口
*    R apply(T t);
*
* predicate<T> 断言型接口
*    boolean test(T t);
* */
public class TestLambda4 {

//    consumer<T> :消费型接口
//*   void  accept(T t);
    @Test
    public void test1(){
        happpy(45.7, (x) -> System.out.println("消费了x = " + x+"元"));

    }
    public void happpy(double money, Consumer<Double> con){
            con.accept(money);
    }


//    * supplier<T> :供给型接口
//*    T get();
//    需求：产生随机数list类型

    @Test
    public void test2(){
        List<Integer> numList = getNumList(7, () -> (int) (Math.random() * 100));
        numList.stream().forEach(System.out::println);
    }

    public List<Integer> getNumList(int num, Supplier<Integer> supplier){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n=supplier.get();
            list.add(n);
        }
        return list;
    }

//    * function<T,R>:函数型接口
//*    R apply(T t);
//    需求：用于处理字符串

    @Test
    public void test3(){
        String result = strhandler("rrrrrgssdfvcc", (e) -> e.toUpperCase());
        System.out.println("result = " + result);
    }
    public String strhandler(String str, Function<String,String> function) {
        return function.apply(str);
    }


//    predicate<T> 断言型接口
//*    boolean test(T t);
//    需求：将满足条件的字符串，放入集合中
    @Test
    public void test4(){
        List<String> list= Arrays.asList("eed","reeref","zhansan","lssi","wanghu");
        List<String> result = strhandle(list, (e) -> e.length() > 5);
        result.stream().forEach(System.out::println);

    }
    public List<String> strhandle(List<String> list, Predicate<String> predicate){
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s))
                result.add(s);
        }
        return result;
    }


}
