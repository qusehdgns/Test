/**
 * 세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
 *
 * 예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
 *
 * 세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.oneDimensionalArray_5;

import java.util.Arrays;
import java.util.Scanner;

public class No_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        double[] arrScore = new double[count];

        for (int i = 0; i < arrScore.length; i++) {
            arrScore[i] = sc.nextInt();
        }

        double max = Arrays.stream(arrScore).max().getAsDouble();

        System.out.println(Arrays.stream(arrScore).map(score -> (score / max) * 100)
                .reduce((x, y) -> x + y).getAsDouble() / (double) arrScore.length);
    }
}
