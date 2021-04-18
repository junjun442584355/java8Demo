package com.wumj.demo.lambda.lambdaDemo2;

import com.wumj.demo.model.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * @author wumj
 * @date 2020-06-19 10:43
 */

/*
 *
 * 方法引用：若lambda体中的内容有方法已经实现了，我们可以使用“方法引用”
 * （可以理解为：方法引用时lambda表达式的另一种表现形式）
 *
 * 主要有三种语法格式：
 * 一：对象::实例方法名
 * 二：类::静态方法名
 * 三：类::实例方法名//一下注意点2
 *
 * 注意：
 * 1、lambda体中调用方法的参数列表和返回值类型，要与函数式接口中抽象方法的参数列表和返回值保持一致！
 * 2、若lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数是，可以使用classname::method
 *
 *
 * 构造器引用：
 * 格式：
 * CalssName :: new
 *
 * 注意：需要调用的构造器的参数列表要和函数式接口中抽象方法的参数列表保持一致！
 *
 * 数组引用：
 * 格式：
 * Type :: new
 * */
public class TestLambda5 {
//    一：对象::实例方法名

    @Test
    public void test1() {
        Consumer<String> con = (e) -> System.out.println("e = " + e);
        con.accept("ffff");


        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("jjj");
    }

//    一：对象::实例方法名
    @Test
    public void test2(){
        Employee employee=new Employee();
        employee.setName("wumj");
        Supplier<String> sup=()-> employee.getName();
        String result = sup.get();
        System.out.println("result = " + result);
        Supplier<String> sup2=employee::getName;
        System.out.println(sup2.get());
    }
// 二：类::静态方法名
    @Test
    public void test3(){
        Comparator<Integer> com=(x,y)->Integer.compare(x,y);
        System.out.println(com.compare(3, 5));
        System.out.println("---------------");

        Comparator<Integer> com2=Integer :: compare;
        System.out.println(com2.compare(3, 6));

    }

//    三：类::实例方法名
    @Test
    public void test4(){
        BiPredicate<String,String> biPredicate=(x,y)->x.equals(y);
        System.out.println(biPredicate.test("ttt", "ttr"));

        BiPredicate<String,String> biPredicate2=String::equals;
        System.out.println(biPredicate2.test("gg", "gg"));

    }

//    构造器引用
    @Test
    public void test5(){
        Supplier<Employee> sup=() ->new Employee();
        Employee employee = sup.get();


//        构造器引用
        Supplier<Employee> sup2=Employee::new;
        System.out.println(sup2.get());

    }

    @Test
    public void test6(){
        Function<Integer,Employee> function=(age) ->new Employee(age);
        System.out.println(function.apply(56));

        Function<Integer,Employee> function2=Employee::new;
        System.out.println(function2.apply(56));


        BiFunction<String,Integer,Employee> biFunction2=Employee::new;
        System.out.println(biFunction2.apply("wumj", 24));

    }

    @Test
    public void test7(){
        Function<Integer,String[]> fun=(e) ->new String[e];
        System.out.println(fun.apply(4).length);

        Function<Integer,String[]> fun2=String[] :: new;
        System.out.println(fun2.apply(10).length);

    }

}
