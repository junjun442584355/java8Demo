package com.wumj.demo.stream;

import com.wumj.demo.model.Employee;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wumj
 * @date 2020-06-19 19:42
 */
public class TestStreamAPI2 {
/**
 *
 * 1、给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
 * 【1，2，4，7】----》【1，4，16，49】
 */

    @Test
    public void test1(){
        Integer[] list1 = new Integer[]{1,3,5,8};
        Arrays.stream(list1)
                .map((x) -> x * x)
                .forEach(System.out::println);;
    }



    List<Employee> list = Arrays.asList(
            new Employee("wumj", 23, 7888.0,Employee.Status.BUSY),
            new Employee("fhw", 18, 8990.0, Employee.Status.FREE),
            new Employee("zhandan", 33, 8990.0, Employee.Status.VOCATION),
            new Employee("zhangsan", 43, 8990.0, Employee.Status.BUSY),
            new Employee("zhangsan", 43, 8990.0, Employee.Status.VOCATION),
            new Employee("zhangsan2", 43, 8990.0, Employee.Status.VOCATION),
            new Employee("zhangsan3", 43, 8990.0, Employee.Status.VOCATION),
            new Employee("zhangsan4", 43, 8990.0, Employee.Status.VOCATION),
            new Employee("lisi", 53, 8990000.0, Employee.Status.FREE));
    /*
     * 怎样用map和reduce判定流中多少个Employee?
     *
     * */
    @Test
    public void test2(){
       /* Optional<Integer> reduce = this.list.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());*/
        DecimalFormat df = new DecimalFormat("####0.00");
        System.out.println(Double.valueOf(
                df.format((double) 10/ 201*100)));

    }

    /*
    *
    *
    *
    * */
}
