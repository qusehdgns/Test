package com.gmoney.switchBreak;

public class Main {
    public static void main(String[] args) {
        String type = "3";

        switch (type) {

            case "1":
                System.out.println("[Test] 1");
                break;

            case "2":
            case "3":
                System.out.println("[Test] 2 + 3");

            default:
                System.out.println("[Test] 4");
                break;

        }
    }
}
