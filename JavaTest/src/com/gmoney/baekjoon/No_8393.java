/**
 * n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon;

import java.util.Scanner;

public class No_8393 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = n;

        for(int i = 1; i < n; i++) {
            result += i;
        }

        System.out.println(result);
    }
}
