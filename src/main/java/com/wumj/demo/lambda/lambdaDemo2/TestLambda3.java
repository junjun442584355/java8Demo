package com.wumj.demo.lambda.lambdaDemo2;

import com.wumj.demo.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wumj
 * @date 2020-06-18 21:40
 */
public class TestLambda3 {
    List<Employee> list = Arrays.asList(
            new Employee("wumj", 23, 7888.0),
            new Employee("fhw", 18, 8990.0),
            new Employee("zhandan", 43, 8990.0),
            new Employee("zhangsan", 43, 8990.0),
            new Employee("lisi", 53, 8990.0));

    //    employee排序，先按照年龄进行比较，若年龄相同则按照姓名比较
    @Test
    public void test1() {
        Collections.sort(list, (x, y) -> {
            if (x.getAge().compareTo(y.getAge()) != 00) {
                return x.getAge().compareTo(y.getAge());
            } else {
                return x.getName().compareTo(y.getName());
            }
        });
        list.stream().forEach(System.out::println);
    }


    /*
     * 编写方法，使用接口myfun2作为参数,将一个字符串转换为大写。并返回
     * */
    @Test
    public void test2() {
        String result = getValueByMyFun("dddcccgg", (e) -> e.toUpperCase());
        System.out.println(result);
        String result2 = getValueByMyFun("\tdddcccgg\t\t\t", (e) -> e.trim());
        System.out.println(result2);
    }

    public String getValueByMyFun(String str, Myfun2 myfun) {
        return myfun.getValue(str);
    }

    /*
     * 两个泛型接口Myfan3
     * 计算两个long类型的参数和
     * 再计算两个long类型的参数积
     * */
    @Test
    public void test3() {
        long result = operationByMyfan3(4L, 70L, (x, y) -> x * y);
        System.out.println("result = " + result);

        result = operationByMyfan3(5L, 8L, (x, y) -> x + y);
        System.out.println("result = " + result);
    }

    public long operationByMyfan3(long param1, long param2, MyFun3<Long, Long> myFun) {
        return myFun.operation(param1, param2);
    }
}
