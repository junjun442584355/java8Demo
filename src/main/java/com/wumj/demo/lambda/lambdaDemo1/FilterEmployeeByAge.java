package com.wumj.demo.lambda.lambdaDemo1;

import com.wumj.demo.model.Employee;

/**
 * @author wumj
 * @date 2020-06-14 21:25
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public Boolean test(Employee employee) {
            return employee.getAge() >= 35;
    }
}
