/**
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.for_3;

import java.util.Scanner;

public class No_11021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int track = sc.nextInt();

        for(int i = 1; i <= track; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println("Case #" + i + ": " + (a + b));
        }
    }
}
