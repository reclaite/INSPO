package ru.kubsu.main.util;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class StringHandler {

    private String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public void reverseString(String string) {
        char[] chars = string.toCharArray();
        String returnStr = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            returnStr += chars[i];
        }
        System.out.println(returnStr);
    }

    public void sortByLastChar(String[] args) {
        HashMap<String, Character> hash = new HashMap<>();
        ArrayList<String> sortedList = new ArrayList<>();
        Arrays.stream(args).forEach(arg -> {
            char[] list = arg.toCharArray();
            hash.put(arg, list[list.length - 1]);
        });
        hash.entrySet().stream().sorted(comparingByValue()).forEach(arg -> sortedList.add(arg.getKey()));
        System.out.println("Отсортированный список: ");
        for(String arg : sortedList) System.out.println(arg);
    }
}
