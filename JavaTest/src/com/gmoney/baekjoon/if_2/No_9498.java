/**
 * 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.if_2;

import java.util.Scanner;

public class No_9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score = sc.nextInt();

        String value;

        switch(score / 10) {
            case 10:
            case 9:
                value = "A";
                break;
            case 8:
                value = "B";
                break;
            case 7:
                value = "C";
                break;
            case 6:
                value = "D";
                break;
            default:
                value = "F";
                break;
        }

        System.out.println(value);
    }
}
