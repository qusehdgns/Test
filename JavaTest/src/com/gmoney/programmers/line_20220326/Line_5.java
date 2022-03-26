package com.gmoney.programmers.line_20220326;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Line_5 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 8, 3, 6, 1, 9, 1, 9}, 2));     //21
        System.out.println(solution(new int[]{7, 6, 8, 9, 10}, 1));             //22
    }

    public static long solution(int[] abilities, int k) {
        Integer[] arrAbilities = Arrays.stream(abilities).boxed().toArray(Integer[]::new);

        ArrayList<Integer> myRecord = new ArrayList<>();

        Arrays.sort(arrAbilities, Collections.reverseOrder());

        // 경우의 수...
        for (int i = 0; i < (arrAbilities.length / 2) + (arrAbilities.length % 2); i++) {
            for (int j = 0; j < k; j++) {
//                for (int l = i; l <; l++) {
//
//                }
            }

        }

        long answer = 0;
        return answer;
    }
}
