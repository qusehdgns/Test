/**
 * 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.basicMath_9;

import java.util.Scanner;

public class No_3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String x1 = sc.next(), y1 = sc.next();
        String x2 = sc.next(), y2 = sc.next();
        String x3 = sc.next(), y3 = sc.next();

        String x, y;

        if(x1.equals(x2)) {
            x = x3;
        } else if(x1.equals(x3)) {
            x = x2;
        } else {
            x = x1;
        }

        if(y1.equals(y2)) {
            y = y3;
        } else if(y1.equals(y3)) {
            y = y2;
        } else {
            y = y1;
        }

        System.out.println(x + " " + y);
    }
}