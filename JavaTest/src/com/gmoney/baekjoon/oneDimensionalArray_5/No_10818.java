/**
 * N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.oneDimensionalArray_5;

import java.util.Arrays;
import java.util.Scanner;

public class No_10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[sc.nextInt()];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.printf("%d %d", Arrays.stream(arr).min().getAsInt(), Arrays.stream(arr).max().getAsInt());
    }
}
