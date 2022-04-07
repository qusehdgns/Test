/**
 * 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.recursionFunc_10;

import java.util.Scanner;

public class No_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int result = 1;

        System.out.println(factorial(num, result));
    }

    public static int factorial(int num, int result) {
        if(num <= 0)
            return result;
        else
            return factorial(num - 1, result * num);
    }
}
