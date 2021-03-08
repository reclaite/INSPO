package ru.kubsu.main;

import ru.kubsu.main.util.DateHandler;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        DateHandler handler = new DateHandler();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        handler.convertBirthday(string);
    }
}
