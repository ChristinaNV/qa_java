package com.example;

import java.util.Arrays;
import java.util.List;

public class Alex extends Lion {

    public Alex(Predator predator) throws Exception {
        super(Sex.MALE, predator, 0); // Нет котят, он самец
    }

    public List<String> getFriends() {
        return Arrays.asList("Марти", "Глория", "Мелман"); // Друзья
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк"; // Где живет
    }

    @Override
    public int getKittens() {
        return 0; // Всегда возвращаем 0, так как котят у него нет
    }

}
