/**
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 *
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.string_7;

import java.util.Arrays;
import java.util.Scanner;

public class No_1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int track = sc.nextInt();
        String[] arrStr = Arrays.stream(new String[track]).map(x -> sc.next()).toArray(String[]::new);

        System.out.println(Arrays.stream(arrStr).map(x -> check(x)).filter(x -> x).count());
    }

    public static boolean check(String str) {
        String[] arrStr = str.toLowerCase().split("");

        for (int i = 0; i < arrStr.length - 1; i++) {
            boolean bCheck = false;
            String letter = arrStr[i];

            for (int j = i; j < arrStr.length; j++) {
                if(letter.equalsIgnoreCase(arrStr[j]) && bCheck) {
                    return false;
                } else if(!letter.equalsIgnoreCase(arrStr[j])) {
                    bCheck = true;
                }
            }
        }

        return true;
    }
}
