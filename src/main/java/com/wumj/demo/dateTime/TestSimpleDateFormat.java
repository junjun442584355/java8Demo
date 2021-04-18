package com.wumj.demo.dateTime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wumj
 * @date 2020-06-20 13:18
 */
public class TestSimpleDateFormat {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       /* SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
        Callable<Date> task=new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return DateFormatThreadLocal.convert("20161218");
            }
        };
        List<Future<Date>> results = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for (Future<Date> result : results) {
            System.out.println("result = " + result.get());
        }

        pool.shutdown();
    }*/

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task=new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20161218",dtf);
            }
        };
        List<Future<LocalDate>> results = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for (Future<LocalDate> result : results) {
            System.out.println("result = " + result.get());
        }

        pool.shutdown();
    }
}
