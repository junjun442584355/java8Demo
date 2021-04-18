package com.wumj.demo.lambda.lambdaDemo2;

/**
 * @author wumj
 * @date 2020-06-15 11:56
 */
@FunctionalInterface
public interface MyFun<T> {
    public T getValue(T num);
}
