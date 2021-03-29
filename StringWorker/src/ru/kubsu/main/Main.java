package ru.kubsu.main;

import ru.kubsu.main.util.StringHandler;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        StringHandler handler = new StringHandler();
        Scanner scan = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            list.add(scan.nextLine());
        }
        handler.sortByLastChar(list.toArray(new String[0]));
    }
}
