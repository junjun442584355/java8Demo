package com.wumj.demo.lambda.lambdaDemo1;

import com.wumj.demo.model.Employee;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wumj
 * @date 2020-06-14 20:41
 */
public class TestLambda {
    @Test
    public void test1() {
        Comparator<Integer> objectComparable = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }

            public boolean equals(Object obj) {
                return false;
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(objectComparable);
    }

    @Test
    public void test2() {
        Comparator<Integer> demo = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> treeSet = new TreeSet<>(demo);

//        TreeSet<Integer> treeSet=new TreeSet<>((x, y) ->Integer.compare(x,y));

    }

    //     需求：获取当前公司中员工年龄大于35的员工信息
    List<Employee> list = Arrays.asList(
            new Employee("wumj", 23, 7888.0),
            new Employee("fhw", 18, 8990.0),
            new Employee("zhandan", 33, 8990.0),
            new Employee("zhangsan", 43, 8990.0),
            new Employee("lisi", 53, 8990.0));

    @Test
    public void test3() {
        List<Employee> collect = list.stream().filter(e -> e.getAge() == 23).collect(Collectors.toList());
        collect.stream().forEach(e-> System.out.println("e = " + e));

//        List<Employee> result = getEmploee(list);
//        for (Employee employee : result) {
//            System.out.println(employee);
//        }
    }

    public List<Employee> getEmploee(List<Employee> list) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge() >= 35) {
                result.add(employee);
            }
        }
        return result;
    }

    //    需求：获取当前员工中员工工资大于5000的员工信息
    public List<Employee> getEmploeeBySalary(List<Employee> list) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getSalary() >= 5000) {
                result.add(employee);
            }
        }
        return result;
    }

    //    优化方式:策略设计模式
    @Test
    public void test4() {
        List<Employee> list = filterEmployee(this.list, new FilterEmployeeByAge());
        for (Employee employee : list) {
            System.out.println(employee);
        }

        System.out.println("------------------------------");
        List<Employee> list2 = filterEmployee(this.list, new FilterEmployeeBySalary());
        for (Employee employee : list2) {
            System.out.println(employee);
        }

    }

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : list) {
            if (mp.test(employee)) {
                result.add(employee);
            }
        }
        return result;

    }

    //    优化方式二：匿名内部类
    @Test
    public void test5() {

        List<Employee> employees = filterEmployee(this.list, new MyPredicate<Employee>() {
            @Override
            public Boolean test(Employee employee) {
                return employee.getAge() > 35;
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }


        System.out.println("--------------------------");

        List<Employee> employees2 = filterEmployee(this.list, new MyPredicate<Employee>() {
            @Override
            public Boolean test(Employee employee) {
                return employee.getSalary() > 8000;
            }
        });
        for (Employee employee : employees2) {
            System.out.println(employee);
        }
    }

    //    优化方式三：lambda表达式
    @Test
    public void test6() {
        List<Employee> employees = filterEmployee(this.list, (x) -> x.getAge() > 35);
        employees.forEach(System.out::println);
        /*for (Employee employee : employees) {
            System.out.println(employee);
        }*/
        System.out.println("----------------------");
        List<Employee> employees2 = filterEmployee(this.list, (x) -> x.getSalary() > 8000);
        employees2.forEach(System.out::println);
       /* for (Employee employee : employees2) {
            System.out.println(employee);
        }*/
    }

//    优化方式四!!!!!!! Stream API
    @Test
    public void test7(){
        this.list.stream()
                 .filter((e) -> e.getAge() > 35)
                 .forEach(System.out::println);
        System.out.println("---------------------");
        this.list.stream()
                .filter((e) -> e.getSalary() > 35)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("---------------------");
        this.list.stream()
                 .map(Employee::getName)
                 .forEach(System.out::println);

    }

}
