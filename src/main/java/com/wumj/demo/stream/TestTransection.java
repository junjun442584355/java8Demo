package com.wumj.demo.stream;

import com.wumj.demo.model.Trader;
import com.wumj.demo.model.Transactoin;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wumj
 * @date 2020-06-19 20:12
 */
public class TestTransection {
    List<Transactoin> transactoins=null;
    @Before
    public void before(){
        Trader trader=new Trader("zhangsan","shanghai");
        Trader trader1=new Trader("zhangsan1","shanghai1");
        Trader trader2=new Trader("zhangsan2","shanghai");
        Trader trader3=new Trader("zhangsan3","shanghai");
        this.transactoins= Arrays.asList(
                new Transactoin(trader3,2011,300),
                new Transactoin(trader,2012,1000),
                new Transactoin(trader,2011,400),
                new Transactoin(trader1,2012,710),
                new Transactoin(trader1,2012,700),
                new Transactoin(trader2,2012,950)
        );
    }

    /*
    *
    * 1、找出2011年发生的所有交易，并按照交易额排序，从低到高
    * 2、交易员都在那些城市工作过？
    * 3、找出所有来自剑桥的交易员，并按姓名排序？
    * 4、返回所有交易员的姓名字符串，按字母顺序排序？
    * 5、有没有交易员是再米兰工作的
    * 6.打印生活在剑桥的所有交易员的所有的交易额
    * 7.所有交易中，最高的交易额是多少
    * 8.找到交易额最小的交易
    * */

    @Test
    public void test1(){
         this.transactoins.stream()
                .filter((e) -> e.getYear().equals(2011))
                .sorted((x, y) -> x.getValue().compareTo(y.getValue()))
                .forEach(System.out::println);
    }
    
    @Test
    public void test2(){
        this.transactoins.stream()
                .map(Transactoin::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test3(){
        this.transactoins.stream()
                .map(Transactoin::getTrader)
                .filter((e)->e.getCity().equals("shanghai"))
                .distinct()
                .sorted((x,y)->x.getName().compareTo(y.getName()))
                .forEach(System.out::println);

    }
    
    @Test
    public void test4(){
        this.transactoins.stream()
                .map(Transactoin::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted((x,y)->x.compareTo(y))
                .forEach(System.out::println);

        System.out.println("------------");
        String collect = this.transactoins.stream()
                .map(Transactoin::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
        System.out.println(collect);

        System.out.println("------------");
        String reduce = this.transactoins.stream()
                .map(Transactoin::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce("", String::concat);
        System.out.println("reduce = " + reduce);

    }

    @Test
    public void test5(){
        this.transactoins.stream()
                .map(Transactoin::getTrader)
                .filter((x)->x.getCity().equals("shanghai1"))
                .distinct()
                .forEach(System.out::println);

    }

    @Test
    public void test6(){
        Optional<Integer> shanghai = this.transactoins.stream()
                .filter((x) -> x.getTrader().getCity().equals("shanghai"))
                .map(Transactoin::getValue)
                .reduce(Integer::sum);
        System.out.println("shanghai = " + shanghai.get());
    }
    @Test
    public void test7(){
        Optional<Transactoin> collect = this.transactoins.stream()
                .collect(Collectors.maxBy((x, y) -> x.getValue().compareTo(y.getValue())));
        System.out.println(collect.get().getValue());

        Optional<Integer> collect1 = this.transactoins.stream()
                .map(Transactoin::getValue)
                .collect(Collectors.maxBy((x, y) -> x.compareTo(y)));
        System.out.println("collect1 = " + collect1);

        Optional<Integer> max = this.transactoins.stream()
                .map(Transactoin::getValue)
                .max(Integer::compareTo);//max(Integer::compare);
        System.out.println("max = " + max.get());
    }


    @Test
    public void test8(){
        Optional<Integer> min = this.transactoins.stream()
                .map(Transactoin::getValue)
                .min(Integer::compare);//max(Integer::compare);
        System.out.println("min = " + min.get());

    }

}
