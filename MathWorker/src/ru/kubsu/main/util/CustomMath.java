package ru.kubsu.main.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class CustomMath {

    public void findMinMaxMiddle(int x, int y, int z) {
        int min, max, mid;
        if (x > y) {
            max = x;
            mid = y;
        } else {
            max = y;
            mid = x;
        }
        if (z > mid) {
            min = mid;
            mid = z;
        } else {
            min = z;
        }
        if (max < mid) {
            max = mid;
            mid = x;
        }
        System.out.println("Минимальное значение >> " + min);
        System.out.println("Среднее значение >> " + mid);
        System.out.println("Максимальное значение >> " + max);
    }

    public int minNumber(int x, int y, int z) {
        return (x <= y) ? (x <= z) ? x : z : (y <= z) ? y : z;
    }

    public int maxNumber(int x, int y, int z) {
        return (x >= y) ? (x >= z) ? x : z : (y >= z) ? y : z;
    }

    public int middleNumber(int x, int y, int z) {
        int min = minNumber(x, y, z);
        int max = maxNumber(x, y, z);
        return (min == x) ? max == y ? z : y :
                (min == y) ? max == x ? z : x :
                        (min == z) ? max == x ? y : x : x;
    }

    public int randomInRange(int min, int max) {
        Random rand = new Random();
        int result = rand.nextInt(max);
        while (result < min)
            result = rand.nextInt(max);
        return result;
    }

    public ArrayList<Integer> primeCounter(int min, int max) {
        ArrayList<Integer> array = new ArrayList<>();
        boolean isPrime = true;
        while (min <= max) {
            for (int k = 2; k <= min; k++) {
                if (min == 2) array.add(min);
                if (min % k == 0 && min != k) {
                    isPrime = false;
                    break;
                }
            }
            if (!array.contains(min) && isPrime) array.add(min);
            isPrime = true;
            min++;
        }
        return array;
    }

    public void binarySearch(int[] list, int number, int min, int max) {
        if(max == list.length) {
            max--;
        }
        int middleNumber = (min + max) / 2;
        System.out.println(Arrays.toString(list) + " " + number + " " + min + " " + max + " " + middleNumber); // debug
        if (list[middleNumber] != number && min == max) {
            System.out.println("Числа нет в ряде");
            return;
        }
        if (list[middleNumber] < number) {
            binarySearch(list, number, (middleNumber + 1), max);
        } else if (list[middleNumber] > number) {
            binarySearch(list, number, 0, (middleNumber - 1));
        } else {
            System.out.println("Число находится под индексом >> " + middleNumber);
        }

    }

    public void binarySearchByCycle(int[] list, int number) {
        int min = 0;
        int max = list.length - 1;
        int middleNumber;
        while (min <= max) {
            middleNumber = (min + max) / 2;
            System.out.println(Arrays.toString(list) + " " + number + " " + min + " " + max + " " + middleNumber); // debug
            if (list[middleNumber] == number) {
                System.out.println("Число находится под индексом >> " + middleNumber);
                return;
            } else if (list[middleNumber] > number) {
                max = middleNumber - 1;
            } else {
                min = middleNumber + 1;
            }
        }
        System.out.println("Числа нет в ряде");
    }
}
