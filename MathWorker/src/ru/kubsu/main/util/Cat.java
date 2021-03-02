package ru.kubsu.main.util;

import java.util.Random;

public class Cat {
    private String name;
    private int weight;
    private boolean isAlive = true;
    private CatDeathCause cause;
    private CustomMath math = new CustomMath();

    public Cat() {
        weight = 1000 + new Random().nextInt(1501);
        announceCatBorn();
    }

    public Cat(String name) {
        this.name = name;
        weight = 1000 + new Random().nextInt(1501);
        announceCatBorn();
    }

    public Cat(String name, int weight) {
        this.name = name;
        this.weight = weight;
        announceCatBorn();
    }

    private void announceCatBorn() {
        System.out.println("Кот " + name + " родился! Его вес составляет " + weight);
    }

    public void feedCat() {
        if(!isAlive) return;
        int difference = math.randomInRange(75, 150);
        weight += difference;
        System.out.println("Кот " + name + " покормлен! Текущий вес кота - " + weight + " (+" + difference +")");
        if(weight >= 5000)
            blowCat();
    }

    public void poopCat() {
        if(!isAlive) return;
        int difference = math.randomInRange(75, 150);
        weight -= difference;
        System.out.println("Кот " + name + " сходил в туалет! Текущий вес кота - " + weight + " (-" + difference +")");
        if(weight <= 600)
            hungerCat();
    }

    public void meowCat() {
        if(!isAlive) return;
        weight--;
        System.out.println("Кот " + name + " мяукнул! Текущий вес кота - " + weight + " (-1)");
        if(weight <= 600)
            soMeowCat();
    }

    public void blowCat() {
        isAlive = false;
        setCause(CatDeathCause.OVERWEIGHT);
        announceDeathCause();
    }

    public void hungerCat() {
        isAlive = false;
        setCause(CatDeathCause.HUNGER);
        announceDeathCause();
    }

    public void soMeowCat() {
        isAlive = false;
        setCause(CatDeathCause.MEOWPOCALYPSE);
        announceDeathCause();
    }

    public void announceDeathCause() {
        System.out.println("К сожалению, кот " + name + " умер...\nПричина смерти - " + cause.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public CatDeathCause getCause() {
        return cause;
    }

    public void setCause(CatDeathCause cause) {
        this.cause = cause;
    }


}
