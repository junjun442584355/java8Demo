package com.wumj.demo.stream;

import com.wumj.demo.model.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wumj
 * @date 2020-06-19 13:39
 */

public class TestStreamAPI {
    /*
     * 一、stream的三个操作步骤：
     * 1创建你stream
     *
     * 2中间操作
     *
     * 3终止操作（终端操作）
     *
     * */
//    创建stream
    @Test
    public void test1(){
//        1、可以通过collection系列集合提供的stream（）或者parallelStream()
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

//        2、通过arrays中的静态方法stream()获取数组流
        Employee[] employees=new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);


//        3、通过stream类的静态方法of()
        Stream<String> stream3 = Stream.of("aa","dd","hh");

//        4、创建无限流
//        迭代
        Stream<Integer> stream4 = Stream.iterate(0, (e) -> e + 9);
//        stream4.limit(10).forEach(System.out::println);
//生成
        Stream<Double> stream5 = Stream.generate(() -> Math.random());
        stream5.limit(9).forEach(System.out::println);
    }

//    中间操作,中间操作不会执行任何操作（延迟加载/惰性求值）
    /*
    * 筛选与切片
    * filter
    * limit
    * skip
    * distinct  :通过hashcode()和equals()进行判断
    * */

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

//    内部迭代：迭代操作由stream API完成
    @Test
    public void test2(){
        this.list.stream()
                .filter((e)->{//中间操作：不会执行任何操作
                    System.out.println("api中间操作");
                    return e.getAge()>35;
                })
                .forEach(System.out::println);//终止操作：一次性执行全部内容，即延迟加载/惰性求值

    }

//    外部迭代
    @Test
    public void test3(){
        Iterator<Employee> employeeIterator = this.list.iterator();
        while (employeeIterator.hasNext()){
            System.out.println(employeeIterator.next());

        }
    }

    @Test
    public void test4(){
        this.list.stream()
                .filter((e)->{//中间操作：不会执行任何操作
                    System.out.println("api中间操作:短路");
                    return e.getAge()>35;
                })
                .limit(1)
                .forEach(System.out::println);
    }

    @Test
    public void test5(){
        this.list.stream()
                .filter((e)->e.getAge()>19)
                .skip(1)  //跳过前几个
                .forEach(System.out::println);
    }

    @Test
    public void test6(){
        this.list.stream()
                .distinct()
                .forEach(System.out::println);
    }

    /*
    * 映射
    * map-----接收lambda,将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，
    * 并将其映射成一个新的元素。
    * flatMap------接收一个函数作为参数，将流中的每一个值都转换成另一个流，然后把所有流多连接成一个流
    *
    * */
    @Test
    public void test7(){
        List<String> strings = Arrays.asList("sss", "ffff", "gfgd", "fgff");
        strings.stream()
                .map((e)->e.toUpperCase())
                .forEach(System.out::println);

        System.out.println("-----------------");
        strings.stream()
                .map(String ::toUpperCase)
                .forEach(System.out::println);

        System.out.println("-------------------");
        this.list.stream()
                .map(Employee::getName)
                .distinct()
                .forEach(System.out::println);

        System.out.println("-------------------");
        Stream<Stream<Character>> resultStream=strings.stream()
                .map(TestStreamAPI::filterCharacter);
        resultStream.forEach((sm)->{
            sm.forEach(System.out::println);
        });

        System.out.println("-------------------");

        Stream<Character> resultStream2=strings .stream()
                                                .flatMap(TestStreamAPI::filterCharacter);
        resultStream2.forEach(System.out::println);


    }

    public static Stream<Character> filterCharacter(String str){
        ArrayList<Character> characters = new ArrayList<>();
        for (Character cha : str.toCharArray()) {
            characters.add(cha);
        }
        return characters.stream();

    }

    /*
    *排序
    * sorted（）----自然排序(comparable)
    * sorted(comparator com)----定制排序(comparator)
    *
    * */
    @Test
    public void test8(){
        List<String> strings = Arrays.asList("sss", "ffff", "gfgd", "fgff");
        strings.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("--------------------");
        this.list.stream()
                .sorted((x,y)->{
                   if(x.getAge().compareTo(y.getAge())==0) {
                       return -x.getName().compareTo(y.getName());
                   }   else{
                       return -x.getAge().compareTo(y.getAge());
                   }
                })
                .forEach(System.out::println);

    }

//    终止操作
    /*
    *查找与匹配
    * allMatch
    * anyMatch
    * noneMatch
    * findFirst
    * finsAny
    * count
    * max
    * min
    *
    * */
    @Test
    public void test9(){
        boolean bl=this.list.stream()
                .allMatch((e)->e.getStatus().equals(Employee.Status.BUSY));
        System.out.println("bl = " + bl);

        boolean bl2=this.list.stream()
                .anyMatch((e)->e.getStatus().equals(Employee.Status.BUSY));
        System.out.println("bl2 = " + bl2);

        boolean bl3=this.list.stream()
                .noneMatch((e)->e.getStatus().equals(Employee.Status.BUSY));
        System.out.println("bl3 = " + bl3);

        Optional<Employee> op= this.list.stream()
                .sorted((x, y) -> x.getAge().compareTo(y.getAge()))
                .findFirst();
        System.out.println(op.get());

        Optional<Employee> op2 = this.list.parallelStream()
                .filter((e) -> e.getStatus().equals(Employee.Status.VOCATION))
                .findAny();
        System.out.println(op2.get());

        long count = this.list.stream()
                .count();
        System.out.println("count = " + count);

        Optional<Employee> op3 = this.list.stream()
                .max((x, y) -> x.getSalary().compareTo(y.getSalary()));
        System.out.println("op3 = " + op3);

        Optional<Employee> op31 = this.list.stream()
                .max(TestStreamAPI::funn);
        System.out.println("op31 = " + op31);

        Optional<Double> op4 = this.list.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println("op4 = " + op4);

        Optional<Double> op5 = this.list.stream()
                .map(Employee::getSalary)
                .min((x,y)->x.compareTo(y));
        System.out.println("op5 = " + op5);



    }

    public static int funn(Employee x,Employee y){
        return x.getSalary().compareTo(y.getSalary());
    }

    /*
    * 归约
    * reduce(T identity, BinaryOperator)/reduce(BinaryOperator)
    * -------------可以将流中元素反复结合起来，得到一个值
    * */
    @Test
    public void test10(){
        List<Integer> integerList = Arrays.asList(1, 3, 6, 8, 455, 33);
        Integer sum = integerList.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println("sum = " + sum);

        System.out.println("-----------------");
        Optional<Double> op10 = this.list.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println("op10 = " + op10);

    }


    /*
    * 收集
    * collect-----将流转换为其他形式。接收一个collector接口的实现，用于给tream中元素做汇总的方法
    * */
    @Test
    public void test11() {

        List<String> collect = this.list.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("------------------");

        Set<String> collect1 = this.list.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        collect1.forEach(System.out::println);
        System.out.println("-------------------------");

        HashSet<String> collect2 = this.list.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        collect2.forEach(System.out::println);
    }

    @Test
    public void test12(){
//        总数
        Long count = this.list.stream()
                .collect(Collectors.counting());
        System.out.println("count = " + count);
//        平均值
        Double avgAge = this.list.stream()
                .collect(Collectors.averagingInt(Employee::getAge));
        System.out.println("avgAge = " + avgAge);

//        总和
        Integer sumAge = this.list.stream()
                .collect(Collectors.summingInt(Employee::getAge));
        System.out.println("sumAge = " +sumAge);

        IntSummaryStatistics collect = this.list.stream()
                .collect(Collectors.summarizingInt(Employee::getAge));
        System.out.println("collect = " + collect);

//        最大值
        Optional<Employee> collect1 = this.list.stream()
                .collect(Collectors.maxBy((x, y) -> x.getAge().compareTo(y.getAge())));
        System.out.println("collect1 = " + collect1.get());

//        最小值
        Optional<Integer> collect2 = this.list.stream()
                .map(Employee::getAge)
                .collect(Collectors.minBy(Integer::compare));
        System.out.println(collect2.get());

    }



//    分组
    @Test
    public void test13(){
        Map<Employee.Status, List<Employee>> collect = this.list.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println("collect = " + collect);

    }

//    多级分组
    @Test
    public void test14(){
        Map<Employee.Status, Map<String, List<Employee>>> collect = this.list.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() <= 30) {
                        return "青年";
                    } else if (e.getAge() <= 50) {
                        return "中年";
                    } else {
                        return "老年";

                    }
                })));
        System.out.println("collect = " + collect);
    }

//    分区
    @Test
    public void test15(){
        Map<Boolean, List<Employee>> collect = this.list.stream()
                .collect(Collectors.partitioningBy((e) -> e.getAge() > 35));
        System.out.println(collect);

    }

    @Test
    public void test16(){

        IntSummaryStatistics collect = this.list.stream()
                .collect(Collectors.summarizingInt(Employee::getAge));
        System.out.println("collect = " + collect);
    }

    @Test
    public void test17(){
        String collect = this.list.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",","----","===="));
        System.out.println("collect = " + collect);

    }
}
