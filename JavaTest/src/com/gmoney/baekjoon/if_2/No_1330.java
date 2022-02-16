/**
 * 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.if_2;

import java.util.Scanner;

public class No_1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a > b ? ">" : (a < b ? "<" : "=="));
    }
}
