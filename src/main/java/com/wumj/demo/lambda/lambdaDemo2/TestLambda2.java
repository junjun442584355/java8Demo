package com.wumj.demo.lambda.lambdaDemo2;

/**
 * @author wumj
 * @date 2020-06-15 11:08
 * <p>
 * lambda表达式的基础语法：
 */

import org.junit.Test;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 1、语法格式
 *语法格式一：无参无返回值
 * () ->System.out.println("helloWorld")
 *
 *语法格式二：有一个参无返回值
 * (e) ->System.out.println("helloWorld")
 *
 * 语法格式三：若只有一个参数，小括号可以不写
 * e ->System.out.println("helloWorld")
 *
 *  语法格式四：两个以上参数参数，有返回值，并且lambda体中有多条语句
 * e ->System.out.println("helloWorld")
 *
 *  语法格式五：lambda体中只有一条语句，大括号和return可以省略
 *
 *
 *  语法格式五：lambda表达式的参数列表的数据类型可以省略不写，
 *  因为jvm编译器可以通过上下文推断出数据类型，即“类型推断”
 *   Comparator<Integer> com1 = (Integer x, Integer y) -> Integer.compare(x, y);
 *
 *   左右遇一括号省
 *   左侧推断类型省
 *
 *   2、lambda表达式需要函数式接口的支持
 *   函数式接口：接口中只有一个抽象方法的接口，称为函数时接口，可以使用注解：@FunctionalInterfa 修饰
 *               可以检查是否是函数式接口
 **/
public class TestLambda2 {
    @Test
    public void test1() {
        int num = 0;//final 可不写
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello wolrd" + num);
            }
        };
        runnable.run();
        System.out.println("---------------------");

        Runnable r1 = () -> System.out.println("hello wolrd");
        r1.run();
    }
    @Test
    public void test2(){
        Consumer<String> con = (x) -> System.out.println("x = " + x);
        con.accept("尚硅谷厉害！");
        System.out.println("-------------------");
        Consumer<String> con1 = x -> System.out.println("x = " + x);
        con1.accept("尚硅谷厉害！");
    }
    @Test
    public void test3(){
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数时接口");
            return Integer.compare(x, y);
        };
        System.out.println(com.compare(3, 6));

        System.out.println("--------------------");
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
        System.out.println(com1.compare(8, 6));

    }

    @Test
    public void test4(){
//        不可以拆开来写，无法类型推断
//         String[] str={"aaa","vvvvv","ggggg"};
    }



//    需求：对一个数进行运算
    @Test
    public void test5(){

       Integer result= operation(100, x -> x*x);
        System.out.println("result = " + result);



    }

    public Integer operation(Integer num, MyFun<Integer> my) {

        return  my.getValue(num);
    }

}
