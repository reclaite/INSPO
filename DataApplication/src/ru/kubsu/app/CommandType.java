package ru.kubsu.app;

import java.util.ArrayList;
import java.util.List;

public enum CommandType {

    HELP("help"),
    ADD("add"),
    UPDATE("update"),
    DELETE("delete"),
    SHOW("show"),
    EXIT("exit");

    String tag;

    CommandType(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public static List<String> getAllTags() {
        List<String> list = new ArrayList<>();
        for (int k = 0; k < values().length; k++) {
            list.add(values()[k].getTag());
        }
        return list;
    }

    public static CommandType getCommandType(int index) {
        return values()[index];
    }
}
