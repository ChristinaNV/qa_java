package com.example;

import java.util.List;

public class Lion {

    private final boolean hasMane;
    private final Predator predator;
    private final int kittensCount;

    public Lion(Sex sex, Predator predator, int kittensCount) {
        this.hasMane = sex.hasMane();
        this.predator = predator;
        this.kittensCount = kittensCount;
    }

    public Lion(Sex sex, Predator predator) {
        this(sex, predator, 1); // Значение по умолчанию
    }

    public Lion(String sex, Predator predator, int kittensCount) throws Exception {
        this(Sex.fromString(sex), predator, kittensCount);
    }

    public Lion(String sex, Predator predator) throws Exception {
        this(Sex.fromString(sex), predator, 1);
    }

    public int getKittens() {
        return kittensCount;
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

    public String getSex() {
        return hasMane ? "Самец" : "Самка";
    }
}
