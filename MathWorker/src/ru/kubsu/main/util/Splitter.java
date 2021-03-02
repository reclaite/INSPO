package ru.kubsu.main.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private String name;
    private String surname;
    private String patronymic;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void splitString(String string) {
        String[] args = string.split(" ");
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    public void splitFullName(String string) {
        String regex = "^[А-Я][а-я]*(\\-[А-Я][а-я]*)?\\s[А-Я][а-я]*(\\s[А-Я][а-я]*(\\-[А-Я][а-я]*)?)?$";
        Pattern pattern = Pattern.compile(regex);
        if(!Pattern.matches(regex, string)) {
            System.out.println("Введены некорректные данные");
            return;
        }
        Matcher matcher = pattern.matcher(string);
        String[] args = new String[0];
        while(matcher.find()) {
            args = string.substring(matcher.start(), matcher.end()).split(" ");
        }
        surname = args[0];
        System.out.println("Фамилия >> " + surname);
        name = args[1];
        System.out.println("Имя >> " + name);
        if(args.length > 2) {
            patronymic = args[2];
            System.out.println("Отчество >> " + patronymic);
        }
    }


    public void splitPhoneNumber(String string) {
        String regex = "^\\+?(7|8)?(\\s|\\-)?\\(?\\d{3}(\\s|\\-)?\\)?\\s?\\d{3}\\-?\\d{2}\\-?\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        if(!Pattern.matches(regex, string)) {
            System.out.println("Введены некорректные данные");
            return;
        }
        Matcher matcher = pattern.matcher(string);
        String arg = "";
        while(matcher.find()) {
            arg = string.substring(matcher.start(), matcher.end());
        }
        String[] regExConverts = {" ", "\\(", "\\)", "\\-", "\\+", "^8"};
        for (String regExConvert : regExConverts) {
            arg = arg.replaceAll(regExConvert, "");
        }
        if(arg.length() == 10)
            arg = "7" + arg;
        System.out.println("Итоговый номер телефона после обработки >> " + arg);
    }
}
