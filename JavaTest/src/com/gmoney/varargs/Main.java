package com.gmoney.varargs;

public class Main {
    public static void main(String[] args) {

        varargsTestFunc("test1", "test2");

    }

    public static void varargsTestFunc(String... values) {
        for(String temp : values) {
            System.out.println(temp);
        }

        return;
    }
}
