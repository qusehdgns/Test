/**
 * 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.basicMath_9;

import java.util.Scanner;

public class No_11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int i = 2; i <= num; i++) {
            if(num % i == 0) {
                System.out.println(i);
                num /= i--;
            }
        }
    }
}
