package com.wumj.demo.annotation;

import com.wumj.demo.model.Employee;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author wumj
 * @date 2020-06-20 15:49
 */
/*
* 重复注解与类型注解
* */
public class TestAnnotation {

    @MyAnnotation("shapi")
    @MyAnnotation("fanhaowen")
    public void show(  @MyAnnotation("wumj")String string){

    }
    @Test
    public void test1(){
        try {
            Method show = TestAnnotation.class.getMethod("show");
            MyAnnotation[] annotationsByType = show.getAnnotationsByType(MyAnnotation.class);
            for (MyAnnotation myAnnotation : annotationsByType) {
                System.out.println("myAnnotation = " + myAnnotation.value());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }


    /*
    * 面试题时随手写的
    *
    * */
    public static int getInt() {
        int a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
            /*
             * return a 在程序执行到这一步的时候，这里不是return a 而是 return 30；这个返回路径就形成了
             * 但是呢，它发现后面还有finally，所以继续执行finally的内容，a=40
             * 再次回到以前的路径,继续走return 30，形成返回路径之后，这里的a就不是a变量了，而是常量30
             */
        } finally {
            a = 40;
            return a;
        }

//      return a;
    }
    @Test
    public void test2(){
       /* List<String> list = Arrays.asList("aaaa", "rrr", "rrrrtt", "eeee");
        List<Employee> list2 = Arrays.asList(
                new Employee("wumj", 23, 7888.0),
                new Employee("fhw", 18, 8990.0),
                new Employee("zhandan", 33, 8990.0),
                new Employee("zhangsan", 43, 8990.0),
                new Employee("lisi", 53, 8990.0));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("--------------");
        list2.stream().sorted((x,y)->x.getAge().compareTo(y.getAge()))
                     .forEach(System.out::println);
        List<Integer> list4 = Arrays.asList(1, 4, 23, 32, 9, 20, 10, 9);
        list4.stream().sorted((x,y)->-x.compareTo(y)).forEach(System.out::println);*/
        System.out.println(getInt());
    }
}
