package com.wumj.demo.model;

/**
 * @author wumj
 * @date 2020-06-19 20:08
 */
/*
* 交易员
* */
public class Trader {
    /**
     *name
     */
    private String name;
    /**
     *city
     */
    private String city;

    public Trader() {
    }

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
