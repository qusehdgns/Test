package com.gmoney.programmers.line_20220326;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Line_2 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"line in line", "LINE", "in lion"}, 5));       // 20
        System.out.println(solution(new String[]{"ABcD", "bdbc", "a", "Line neWs"}, 7));        // 12
    }

    public static int solution(String[] sentences, int n) {
        int[] arrScore = Arrays.stream(sentences)
                .mapToInt(sentence -> sentence.length() + sentence.replaceAll("[^A-Z]", "").length())
                .toArray();
        ArrayList<ArrayList<String>> arrListKey = new ArrayList<>(Arrays.stream(sentences).map(sentence -> {
            ArrayList<String> arrSplit = new ArrayList<>(Arrays.stream(sentence.replaceAll(" ", "")
                    .toLowerCase().split("")).distinct().collect(Collectors.toList()));

            if (sentence.replaceAll("[^A-Z]", "").length() > 0)
                arrSplit.add("Shift");

            return arrSplit;
        }).collect(Collectors.toList()));

        int[] arrTotalScore = new int[sentences.length];

        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < arrListKey.size(); j++) {
                if (i == j) {
                    arrTotalScore[i] += arrScore[j];
                    continue;
                }

                List<String> left = new ArrayList<>(arrListKey.get(j));

                left.removeAll(arrListKey.get(i));

                if (left.size() == 0) {
                    arrTotalScore[i] += arrScore[j];
                }
            }
        }

        return Arrays.stream(arrTotalScore).max().getAsInt();
    }
}
