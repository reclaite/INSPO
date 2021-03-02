package ru.kubsu.main.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Person {
    private int id;
    private float temperature = 1F;
    private static Random rand = new Random();
    private static HashMap<Integer, Person> personList = new HashMap<>();
    private static int startID;
    private static DecimalFormat decimalFormat = new DecimalFormat("#.#");

    Person(int id) {
        if (personList.size() == 0) {
            startID = id;
        }
        this.id = id;
        personList.put(id, this);
    }

    public int getId() {
        return id;
    }

    public static void generatePatientsTemperatures() {
        float min = 32F;
        float max = 40F;
        for (int i = startID; i < personList.size(); i++) {
            float flt = min + rand.nextFloat() * (max - min);
            flt = Float.parseFloat(decimalFormat.format(flt));
            Person person = personList.get(i);
            person.setTemperature(flt);
        }
    }

    public static void getReport() {
        List<Integer> legalPersonsID = new ArrayList<>();
        float sum = 0;
        for (int i = startID; i < personList.size(); i++) {
            Person person = personList.get(i);
            if (person.getTemperature() >= 36.2F && person.getTemperature() <= 36.9F) {
                legalPersonsID.add(person.getId());
            }
            System.out.println("Персона >> ID: " + person.getId() + " | Температура: " + person.getTemperature());
        }
        for (Integer personNumber : legalPersonsID) {
            sum += Person.getPersonByID(personNumber).getTemperature();
        }
        System.out.println("Среднее арифметическое приемлемых температур >> " + Float.parseFloat(decimalFormat.format(sum / legalPersonsID.size())));
        System.out.println("Приемлемую температуру имеют персоны с ID >> " + legalPersonsID.toString() + " (" + legalPersonsID.size() + " персон)");
    }

    public static Person getPersonByID(int id) {
        return personList.get(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
