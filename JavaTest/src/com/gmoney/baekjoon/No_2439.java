/**
 * 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
 *
 * 하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
 */
package com.gmoney.baekjoon;

import java.util.Scanner;

public class No_2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for(int i = 1; i <= num; i++) {
            for(int j = num - i; j > 0; j--) {
                System.out.print(" ");
            }
            for(int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
