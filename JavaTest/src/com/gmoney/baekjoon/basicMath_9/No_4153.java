/**
 * 과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
 *
 * https://www.acmicpc.net/problem/4153
 */
package com.gmoney.baekjoon.basicMath_9;

import java.util.Scanner;

public class No_4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

            if(a == 0 && a == b && b == c && c == a)
                break;

            if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)
                    || Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)
                    || Math.pow(c, 2) + Math.pow(a, 2) == Math.pow(b, 2))
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}
