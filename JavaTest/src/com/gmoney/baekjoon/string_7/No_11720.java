/**
 * N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.string_7;

import java.util.Arrays;
import java.util.Scanner;

public class No_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /** not use */
        int length = sc.nextInt();
        String str = sc.next();

        System.out.println(Arrays.stream(str.split("")).mapToInt(x -> Integer.parseInt(x)).sum());
    }
}
