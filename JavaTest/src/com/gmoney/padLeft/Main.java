package com.gmoney.padLeft;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String passportNum = sc.next();

        String regNum = passportNum.replaceAll("[^0-9]", "");

        String result = regNum.length() > 5 ? regNum.substring(regNum.length() - 5) : padLeftZeros(regNum, 5);

        System.out.println(result);
    }

    public static String padLeftZeros(String value, int length) {
        return padLeft(value, length, '0');
    }

    public static String padLeft(String value, int length, char padValue) {
        return String.format("%" + length + "s", value).replace(' ', padValue);
    }
}
