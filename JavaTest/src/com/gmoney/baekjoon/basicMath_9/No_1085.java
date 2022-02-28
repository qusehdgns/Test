/**
 * 한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.basicMath_9;

import java.util.Arrays;
import java.util.Scanner;

public class No_1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(), y = sc.nextInt(), w = sc.nextInt(), h = sc.nextInt();

        System.out.println(Arrays.stream(new int[] {x, y, w - x, h - y}).min().getAsInt());
    }
}
