package com.wumj.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author wumj
 * @date 2020-06-14 21:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee2 {
    /**
     *nanme
     */
    private String name;
    /**
     *age
     */
    private String age;
    /**
     *dalary
     */
    private Double salary;

    private Status status;

    public enum Status{
        FREE,
        BUSY,
        VOCATION
    }
}
