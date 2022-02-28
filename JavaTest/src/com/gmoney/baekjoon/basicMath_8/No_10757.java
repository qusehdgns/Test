/**
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.basicMath_8;

import java.util.Scanner;

public class No_10757 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] a = sc.next().split(""), b = sc.next().split("");

        int diff = a.length - b.length;
        boolean upper = false;
        String result = "";

        for (int i = (diff < 0 ? b.length : a.length) - 1; i >= 0 ; i--) {
            int calc;

            if(diff < 0) {
                if(i + diff >= 0) {
                    calc = Integer.parseInt(a[i + diff]) + Integer.parseInt(b[i]) + (upper ? 1 : 0);
                } else {
                    calc = Integer.parseInt(b[i]) + (upper ? 1 : 0);
                }
            } else {
                if(i - diff >= 0) {
                    calc = Integer.parseInt(a[i]) + Integer.parseInt(b[i - diff]) + (upper ? 1 : 0);
                } else {
                    calc = Integer.parseInt(a[i]) + (upper ? 1 : 0);
                }
            }

            result = (calc % 10) + result;

            upper = calc / 10 > 0;
        }

        result = (upper ? "1" : "") + result;

        System.out.println(result);
    }
}
