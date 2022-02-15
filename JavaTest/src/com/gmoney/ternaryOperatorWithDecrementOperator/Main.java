package com.gmoney.ternaryOperatorWithDecrementOperator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int minute = sc.nextInt();

        hour = (minute - 45) >= 0 ? hour : (--hour >= 0 ? hour : hour + 24);
        minute = (minute - 45) >= 0 ? minute : minute + 15;

        System.out.println(hour + " " + minute);
    }
}
