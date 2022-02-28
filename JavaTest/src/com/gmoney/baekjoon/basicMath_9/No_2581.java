/**
 * 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
 *
 * 예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.
 */
package com.gmoney.baekjoon.basicMath_9;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class No_2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();

        int[] arrNum = IntStream.range(m > 1 ? m : 2, n + 1).toArray();

        arrNum = Arrays.stream(arrNum).filter(num -> {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0)
                    return false;
            }

            return true;
        }).toArray();

        if(arrNum.length < 1) {
            System.out.println(-1);
        } else {
            System.out.println(Arrays.stream(arrNum).sum());
            System.out.println(arrNum[0]);
        }
    }
}
