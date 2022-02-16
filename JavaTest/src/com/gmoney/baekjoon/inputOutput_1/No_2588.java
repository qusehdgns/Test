/**
 * (세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
 *
 * https://www.acmicpc.net/problem/2588
 *
 * (1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.inputOutput_1;

import java.util.Scanner;

public class No_2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int first = sc.nextInt();
        int second = sc.nextInt();

        System.out.println(first * (second % 10));
        System.out.println(first * ((second % 100) / 10));
        System.out.println(first * (second / 100));

        System.out.println(first * second);
    }
}
