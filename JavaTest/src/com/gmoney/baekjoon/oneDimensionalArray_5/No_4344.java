/**
 * 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
 */
package com.gmoney.baekjoon.oneDimensionalArray_5;

import java.util.Arrays;
import java.util.Scanner;

public class No_4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int track = sc.nextInt();
        double[] arrPercent = new double[track];

        for (int i = 0; i < arrPercent.length; i++) {
            int[] arrScore = new int[sc.nextInt()];

            for (int j = 0; j < arrScore.length; j++) {
                arrScore[j] = sc.nextInt();
            }

            double avg = Arrays.stream(arrScore).reduce((x, y) -> x + y).getAsInt() / (double) arrScore.length;

            arrPercent[i] = (Arrays.stream(arrScore).filter(score -> score > avg).count() / (double) arrScore.length) * 100;
        }

        Arrays.stream(arrPercent).forEach(percent -> System.out.printf("%.3f%%\n", percent));
    }
}
