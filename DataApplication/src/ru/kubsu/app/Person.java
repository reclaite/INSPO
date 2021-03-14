package ru.kubsu.app;

import ru.kubsu.app.util.ConsoleColors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private int id;
    private String surname, name, middlename;
    private String phoneNumber;

    public Person(int id, String[] fullName) {
        splitName(fullName);
        this.id = id;
    }

    public Person(int id, String surname, String name, String middlename) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
    }

    private void splitName(String[] fullName) {
        surname = fullName[1].trim();
        name = fullName[2].trim();
        middlename = fullName[3].trim();
    }

    public void updateName(String[] args) {
        surname =args[2];
        name = args[3];
        middlename = args[4];
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middlename;
    }

    public String getFullName() {
        return surname + " " + name + " " + middlename;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String string) {
        String regex = "^\\+?(7|8)?(\\s|\\-)?\\(?\\d{3}(\\s|\\-)?\\)?\\s?\\d{3}\\-?\\d{2}\\-?\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        if (!Pattern.matches(regex, string)) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Введены некорректные данные"
                    + ConsoleColors.RESET);
            return;
        }
        Matcher matcher = pattern.matcher(string);
        String arg = "";
        while (matcher.find()) {
            arg = string.substring(matcher.start(), matcher.end());
        }
        String[] regExConverts = {" ", "\\(", "\\)", "\\-", "\\+", "^8"};
        for (String regExConvert : regExConverts) {
            arg = arg.replaceAll(regExConvert, "");
        }
        if (arg.length() == 10)
            arg = "7" + arg;
        phoneNumber = arg;
    }

    public void implementNumber(Person person) {
        phoneNumber = person.getPhoneNumber();
    }


}
