package com.gmoney.programmers.sk_20220312;

import java.util.Arrays;

public class Sk_2 {
    public static void main(String[] args) {
        Arrays.stream(solution(5, true)).forEach(arr -> System.out.println(Arrays.toString(arr)));
        Arrays.stream(solution(6, false)).forEach(arr -> System.out.println(Arrays.toString(arr)));
        Arrays.stream(solution(9, false)).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    public static int[][] solution(int n, boolean clockwise) {
        int[][] answer = new int[n][n];

        final int max_index = n - 1;

        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int reverse_i = max_index - i;
                int reverse_j = max_index - j;

                if(clockwise) {
                    if (answer[i][j] != 0)
                        continue;

                    answer[i][j] = num;
                    answer[j][reverse_i] = num;
                    answer[reverse_i][reverse_j] = num;
                    answer[reverse_j][i] = num++;
                } else {
                    if (answer[j][i] != 0)
                        continue;

                    answer[j][i] = num;
                    answer[i][reverse_j] = num;
                    answer[reverse_j][reverse_i] = num;
                    answer[reverse_i][j] = num++;
                }
            }
        }

        return answer;
    }
}
