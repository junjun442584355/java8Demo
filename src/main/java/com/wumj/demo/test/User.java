package com.wumj.demo.test;

import java.io.Serializable;

/**
 * @author wumj
 * @date 2021-03-30 11:50
 * @description
 */
public class User {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private Integer age;

    /**
     *
     */
    private String name;

    public User() {
    }

    public User(Integer id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}
