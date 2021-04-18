package com.wumj.demo.lambda.lambdaDemo1;

import com.wumj.demo.model.Employee;

/**
 * @author wumj
 * @date 2020-06-14 21:37
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {

    @Override
    public Boolean test(Employee employee) {
        return employee.getSalary()>8000;
    }
}
