package com.wumj.demo.optional;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.wumj.demo.model.Employee;
import com.wumj.demo.model.Godness;
import com.wumj.demo.model.Man;
import com.wumj.demo.model.NewMan;
import org.junit.Test;

import java.util.Optional;

/**
 * @author wumj
 * @date 2020-06-20 11:32
 */
public class TestOptional {
    /*
    * Optional.of(T t):创建一个Optiaonal实例
    * Optional.empty（）；创建一个空Optional实例
    * Optional.ofNullable(T t):若t不为null，创建一个Optiaonal实例，否则创建空实例
    * isPresent:判定是否包含值
    * orElse(T t):如果调用对象包含值，返回该值，否则返回t
    * orElseGet(Supplier s):如果调用对象包含值，返回该值，否则返回s获取的值
    * map(Function f):如果有值对其处理，并返回处理后的Optional,否则返回Optional.empty（）
    *flatMap(Fuction mapper):与map类似，要求返回值必须是Optional
   *
    * */

    @Test
    public void test1(){
        Optional<Employee> employee = Optional.of(new Employee());
        System.out.println("employee = " + employee.get());
    }

    @Test
    public void test2(){
        Optional<Employee> empty = Optional.empty();
        System.out.println("empty = " + empty.get());
    }

    @Test
    public void test3(){
        Optional<Employee> employee = Optional.ofNullable(null);
        if (employee.isPresent()){
            System.out.println("employee = " + employee.get());

        }
        Employee zhansan = employee.orElse(new Employee("zhansan", 34, 56890.9));
        System.out.println("zhansan = " + zhansan);

        Employee employee1 = employee.orElseGet(Employee::new);
        System.out.println("employee1 = " + employee1);
    }

    @Test
    public void test4(){
        Optional<Employee> zhansan = Optional.ofNullable(new Employee("zhansan", 34, 56890.9));
        Optional<String> s = zhansan.map(Employee::getName);
        System.out.println("s = " + s.get());

        Optional<String> s1 = zhansan.flatMap((e) -> Optional.ofNullable(null));
        System.out.println("s1 = " + s1.get());
    }


//    例题:
//    需求：获取一个男人心中女生的名字
    @Test
    public void tets5(){
        Man man = new Man();

        String name = getGodbessName(man);
        if (name!=null &&name!=""){
            System.out.println("name = " + name);
        }
    }

    @Test
    public void tets6(){
        Optional<Godness> godness=Optional.ofNullable(new Godness("lisi"));
        Optional<NewMan> newMan = Optional.ofNullable(new NewMan(godness));
        String godbessName2 = getGodbessName2(newMan);
        System.out.println("godbessName2 = " + godbessName2);

    }
    private String getGodbessName2(Optional<NewMan> man){
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("zhandan"))
                .getName();

    }    /**
     *获取女神的名字
     */
    private String getGodbessName(Man man){
//        return man.getGodness().getName();
       if (man!=null && man.getGodness()!=null)
           return man.getGodness().getName();
       else
           return null;
    }


}
