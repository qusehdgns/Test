/**
 * 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.for_3;

import java.util.Scanner;

public class No_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int track = sc.nextInt();
        int value = sc.nextInt();
        int[] arrNum = new int[track];

        for(int i = 0; i < track; i++) {
            arrNum[i] = sc.nextInt();
        }

        for(int num : arrNum) {
            if(num < value)
                System.out.print(num + " ");
        }
    }
}
