package com.wumj.demo.model;

import java.util.Optional;

/**
 * @author wumj
 * @date 2020-06-20 12:26
 */
public class NewMan {
    private Optional<Godness> godness=Optional.empty();

    public NewMan(Optional<Godness> godness) {
        this.godness = godness;
    }

    public NewMan() {
    }

    @Override
    public String toString() {
        return "NewMan{" +
                "godness=" + godness +
                '}';
    }

    public Optional<Godness> getGodness() {
        return godness;
    }

    public void setGodness(Optional<Godness> godness) {
        this.godness = godness;
    }
}
