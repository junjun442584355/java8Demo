package com.wumj.demo.forkjoin;

import org.junit.Test;
import sun.security.jca.GetInstance;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author wumj
 * @date 2020-06-19 21:45
 */
public class TestForkJoin {
    @Test
    public void test1(){
        Instant now = Instant.now();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task=new ForkJoinCalculate(0,100000000L);
        Long sun = forkJoinPool.invoke(task);
        System.out.println("sun = " + sun);
        Instant end = Instant.now();
        System.out.println("时间："+Duration.between(now,end).toMillis());

    }

    @Test
    public void test2(){
        Instant now = Instant.now();
        long sum=0;
        for (long i = 0; i <= 100000000; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
        Instant end = Instant.now();
        System.out.println("时间："+Duration.between(now,end).toMillis());
    }

    /*
    * Java8并行流
    *
    * */
    @Test
    public void test3(){
        Instant now = Instant.now();
        long reduce = LongStream.rangeClosed(0, 20000L)
                .parallel()
                .reduce(0, Long::sum);
        System.out.println("reduce = " + reduce);
        Instant end = Instant.now();
        System.out.println("时间："+Duration.between(now,end).toMillis());

    }
}
