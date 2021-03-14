package ru.kubsu.app;

import ru.kubsu.app.util.ConsoleColors;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean isExited = false;
    static String version = "1.0";
    public static String source = "cmd";
    private static DataProgram program = new DataProgram();

    public static void main(String[] args) throws InterruptedException {
        ConsoleColors.checkSource();
        program.sendGreetingMessage();
        while (!isExited) {
            String input = scanner.nextLine();
            String[] command = input.split("\\s+");
            String cmdTag = command[0].toLowerCase();

            // Выход из программы, если тег равен EXIT
            if (cmdTag.equals(CommandType.EXIT.getTag())) {
                System.out.println(ConsoleColors.GREEN + "Произвожу выход из программы...");
                isExited = true;
                Thread.sleep(2000);
                return;
            }

            // Неизвестная команда
            if (!CommandType.getAllTags().contains(cmdTag)) {
                System.out.println(ConsoleColors.CYAN + "Введена неизвестная команда..." +
                        "\nВведите HELP для вывода списка команд" + ConsoleColors.RESET);
                continue;
            }

            CommandType type = CommandType.getCommandType(CommandType.getAllTags().indexOf(cmdTag));
            program.executeCommand(type, command);
        }
    }
}
