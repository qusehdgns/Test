/**
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 */
package com.gmoney.baekjoon.string_7;

import java.util.Arrays;
import java.util.Scanner;

public class No_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arrStr = sc.next().toUpperCase().split("");

        String[] arrStrDistinct = Arrays.stream(arrStr).distinct().toArray(String[]::new);

        int[] arrCount = Arrays.stream(arrStrDistinct)
                .mapToInt(letter -> (int) Arrays.stream(arrStr)
                        .filter(str -> str.equalsIgnoreCase(letter)).count()).toArray();

        String[] arrCountStr = Arrays.stream(arrCount).mapToObj(x -> Integer.toString(x)).toArray(String[]::new);

        String maxCount = Integer.toString(Arrays.stream(arrCount).max().getAsInt());

        System.out.println(
                Arrays.stream(arrCountStr).filter(x -> x.equalsIgnoreCase(maxCount)).count() != 1 ?
                        "?" :
                        arrStrDistinct[Arrays.asList(arrCountStr).indexOf(maxCount)]
                );
    }
}
