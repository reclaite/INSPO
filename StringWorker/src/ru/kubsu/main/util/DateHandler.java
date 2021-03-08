package ru.kubsu.main.util;

import java.util.*;

public class DateHandler {

    private Date date = null;
    private int day, month, year;

    public void convertBirthday(String strDate) {

        String[] args = strDate.split("\\.");
        if (args.length != 3 || Integer.parseInt(args[1]) > 12) {
            System.out.println("Некорректный ввод даты рождения");
            return;
        }
        day = Integer.parseInt(args[0]);
        month = Integer.parseInt(args[1]);
        year = Integer.parseInt(args[2]);

        int year = Calendar.getInstance().get(Calendar.YEAR);
        for(int k = this.year; k < year; k++) {
            Calendar calendar = new GregorianCalendar(k, (month -1), day);
            date = calendar.getTime();
            calendar.setTime(date);
            System.out.println(day + "." + month + "." + k + " | День недели - " + convertIntToDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK)));
        }
    }

    public String getBirthdayDate() {
        return day + "." + month + "." + year;
    }

    public String convertIntToDayOfWeek(int day) {
        switch (day) {
            case 2:
                return "Понедельник";
            case 3:
                return "Вторник";
            case 4:
                return "Среда";
            case 5:
                return "Четверг";
            case 6:
                return "Пятница";
            case 7:
                return "Суббота";
            case 1:
                return "Воскресенье";
        }
        return "Несуществующий день";
    }
}
