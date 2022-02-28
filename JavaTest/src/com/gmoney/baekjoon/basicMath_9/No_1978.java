/**
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.basicMath_9;

import java.util.Arrays;
import java.util.Scanner;

public class No_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[sc.nextInt()];

        arr = Arrays.stream(arr).map(x -> sc.nextInt()).toArray();

        System.out.println(Arrays.stream(arr).filter(num -> {
            if(num <= 1)
                return false;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0)
                    return false;
            }

            return true;
        }).count());
    }
}
