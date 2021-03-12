package ru.kubsu.main;

import ru.kubsu.main.util.CustomMath;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CustomMath math = new CustomMath();
//        int[] list = {2, 3, 5, 10, 50, 95, 99, 101, 200, 400, 500};
//        int value = scanner.nextInt();
//        math.binarySearch(list, value, 0, list.length);
//        math.binarySearchByCycle(list, value);

        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        int max = scanner.nextInt();

        System.out.println(math.primeCounter(min, max));

    }
}
