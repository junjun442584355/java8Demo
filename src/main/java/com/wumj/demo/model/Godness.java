package com.wumj.demo.model;

/**
 * @author wumj
 * @date 2020-06-20 12:12
 */
public class Godness {


    /**
     *nanme
     */
    private String name;

    public Godness(String name) {
        this.name = name;
    }

    public Godness() {
    }

    @Override
    public String toString() {
        return "Godness{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
