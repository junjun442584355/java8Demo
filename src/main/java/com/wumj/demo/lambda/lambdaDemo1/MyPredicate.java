package com.wumj.demo.lambda.lambdaDemo1;

import sun.net.idn.Punycode;

/**
 * @author wumj
 * @date 2020-06-14 21:22
 */
@FunctionalInterface
public interface MyPredicate<T> {
    public Boolean test(T t);}
