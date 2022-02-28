/**
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.basicMath_9;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class No_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();

        int[] arrNum = IntStream.range(m > 1 ? m : 2, n + 1).toArray();

        Arrays.stream(arrNum).forEach(num -> {
            boolean isPrime = true;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime)
                System.out.println(num);
        });
    }
}
