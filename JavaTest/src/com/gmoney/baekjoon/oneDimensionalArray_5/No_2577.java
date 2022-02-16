/**
 * 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
 *
 * 예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고, 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
 */
package com.gmoney.baekjoon.oneDimensionalArray_5;

import java.util.Arrays;
import java.util.Scanner;

public class No_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[3];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        String[] calc_result = Integer.toString(Arrays.stream(arr).reduce((x, y) -> x * y).getAsInt()).split("");

        for (int i = 0; i <= 9; i++) {
            int num = i;
            System.out.println(Arrays.stream(calc_result).filter(value -> value.contains(Integer.toString(num))).count());
        }
    }
}
