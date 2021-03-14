package ru.kubsu.app;

import ru.kubsu.app.util.ConsoleColors;

import java.util.ArrayList;
import java.util.HashMap;

public class DataProgram {

    private ArrayList<Person> PERSONS = new ArrayList<>();
    private HashMap<Person, Integer> VALUES = new HashMap<>();

    public void sendGreetingMessage() {
        System.out.println(ConsoleColors.GREEN + "=============== DATABASE APPLICATION V." + Main.version + " ===============" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BRIGHT + "Добро пожаловать в программу базы номеров, введите HELP для поиска всех команд" + ConsoleColors.RESET);
    }

    public void usageMessage(String commandTag, CommandType type) {
        System.out.print(ConsoleColors.RED_BRIGHT + "Использование: " + ConsoleColors.RESET + commandTag);
        switch (type) {
            case DELETE:
                System.out.println(" <ID>");
                break;
            case ADD:
                System.out.println(" <Фамилия> <Имя> <Отчество> <Номер_Телефона>");
                break;
            case UPDATE:
                System.out.println(" <ID> | <Фамилия> <Имя> <Отчество> <Номер_Телефона/THIS>");
                break;
            default:
                break;
        }
    }

    public Person findPerson(String surname, String name, String middlename) {
        String fullName = surname + " " + name + " " + middlename;
        for (Person person : PERSONS) {
            if (person.getFullName().equals(fullName))
                return person;
        }
        return null;
    }

    public Person findPerson(String id) {
        int newId = Integer.parseInt(id);
        for (Person person : PERSONS) {
            if(person.getId() == newId) {
                return person;
            }
        }
        return null;
    }

    public void addCommand(String[] name) {
        int id = VALUES.size();
        while (VALUES.containsValue(id))
            id++;
        Person person = new Person(id, name);
        person.setPhoneNumber(name[4]);
        if(person.getPhoneNumber() == null) {
            return;
        }
        VALUES.put(person, id);
        PERSONS.add(person);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Успешно добавлено значение \""
                + person.getFullName() + "\", присвоен ID - " + id + ConsoleColors.RESET);
    }

    public void helpCommand() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Список команд программы:" + ConsoleColors.BLUE);
        for (String tag : CommandType.getAllTags()) {
            if (!tag.equals(CommandType.HELP.tag)) {
                System.out.println("    " + tag);
            }
        }
        System.out.println(ConsoleColors.RESET);
    }

    public void showCommand() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Значения в базе: \nID  Person" +
                "                           PHONE" + ConsoleColors.BLUE_BRIGHT);
        for (Person person : PERSONS) {
            System.out.println(person.getId() + "   " + person.getFullName() + "   " + person.getPhoneNumber());
        }
    }

    public void updateCommand(String[] args) {
        Person oldPerson = findPerson(args[1]);
        if (oldPerson == null) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Такого значения в базе не найдено!"
                    + ConsoleColors.RESET);
            return;
        }
        int id = oldPerson.getId();
        String oldName = oldPerson.getFullName();
        oldPerson.updateName(args);
        if(!args[5].equals("this")) {
            oldPerson.setPhoneNumber(args[5]);
        }
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Успешно обновлено значение \""
                + oldName + "\" на \"" + oldPerson.getFullName() + "\", присвоен ID - " +
                "" + id + ConsoleColors.RESET);
    }

    public void deleteCommand(String[] args) {
        Person person = findPerson(args[1]);
        if (person == null) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Такого значения в базе не найдено!"
                    + ConsoleColors.RESET);
            return;
        }
        int id = VALUES.get(person);
        VALUES.remove(person, id);
        PERSONS.remove(person);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Успешно удалено значение \""
                + person.getFullName() + "\", ID - " + id + ConsoleColors.RESET);
    }

    public void executeCommand(CommandType type, String[] command) {
        switch (type) {
            case ADD:
                if (command.length != 5) {
                    usageMessage(type.getTag(), type);
                    break;
                }
                addCommand(command);
                break;
            case HELP:
                helpCommand();
                break;
            case SHOW:
                showCommand();
                break;
            case UPDATE:
                if (command.length != 6) {
                    usageMessage(type.getTag(), type);
                    break;
                }
                updateCommand(command);
                break;
            case DELETE:
                if (command.length != 2) {
                    usageMessage(type.getTag(), type);
                    break;
                }
                deleteCommand(command);
            default:
                break;
        }
    }
}
