package com.wumj.demo.lambda.lambdaDemo2;

/**
 * @author wumj
 * @date 2020-06-18 22:03
 */
@FunctionalInterface
public interface MyFun3<T,R> {
    public R operation(T t1,T t2);
}
