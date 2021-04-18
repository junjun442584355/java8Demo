package com.wumj.demo.model;

/**
 * @author wumj
 * @date 2020-06-20 12:11
 */
public class Man {
    private Godness  godness;

    @Override
    public String toString() {
        return "Man{" +
                "godness=" + godness +
                '}';
    }

    public Godness getGodness() {
        return godness;
    }

    public void setGodness(Godness godness) {
        this.godness = godness;
    }

    public Man() {
    }

    public Man(Godness godness) {
        this.godness = godness;
    }
}
