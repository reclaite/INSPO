package ru.kubsu.main.util;

public enum CatDeathCause {
    OVERWEIGHT("Взрыв от переедания"),
    HUNGER("Голод"),
    MEOWPOCALYPSE("Домяукался, хотя чисто формально голод");

    String name;

    CatDeathCause(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
