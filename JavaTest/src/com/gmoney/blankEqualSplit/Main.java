package com.gmoney.blankEqualSplit;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> roleList_1 = List.of(",1,2,3".split(","));
        List<String> roleList_2 = List.of("1,2,3".split(","));

        System.out.println(roleList_1.contains(""));
        System.out.println(roleList_2.contains(""));
    }
}
