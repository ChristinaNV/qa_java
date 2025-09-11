package com.example;

public enum Sex {

    MALE("Самец", true),
    FEMALE("Самка", false);

    private final String displayName;
    private final boolean hasMane;

    Sex(String displayName, boolean hasMane) {
        this.displayName = displayName;
        this.hasMane = hasMane;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean hasMane() {
        return hasMane;
    }

    // Метод для преобразования строки в enum
    public static Sex fromString(String value) throws Exception {
        for (Sex sex : Sex.values()) {
            if (sex.getDisplayName().equalsIgnoreCase(value)) {
                return sex;
            }
        }
        throw new Exception("Используйте допустимые значения пола животного - самец или самка");
    }
}
