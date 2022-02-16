/**
 * 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.function_6;

import java.util.Scanner;

public class No_1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(count(sc.nextInt()));
    }

    public static int count(int num) {
        int count = 0;

        for (int i = 1; i <= num; i++) {
            if(i < 100 || check(i))
                count++;
        }

        return count;
    }

    public static boolean check(int num) {
        int gap = ((num % 100) / 10) - (num % 10);

        while(num > 99) {
            num /= 10;

            if(((num % 100) / 10) - (num % 10) != gap) {
                return false;
            }
        }

        return true;
    }
}
