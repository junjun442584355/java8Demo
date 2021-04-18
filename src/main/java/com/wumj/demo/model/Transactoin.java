package com.wumj.demo.model;

/**
 * @author wumj
 * @date 2020-06-19 20:09
 */
/*
* 交易类
* */
public class Transactoin {
    private Trader trader;
    /**
     *year
     */
    private Integer year;
    /**
     *value
     */
    private Integer value;

    public Transactoin(Trader trader, Integer year, Integer value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transactoin{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Transactoin() {
    }
}
