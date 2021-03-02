package ru.kubsu.main.util;

public class StringHandler {

    public void reverseString(String string) {
        char[] chars = string.toCharArray();
        String returnStr = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            returnStr += chars[i];
        }
        System.out.println(returnStr);
    }
}
