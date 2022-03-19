package com.gmoney.programmers.sk_20220319;

import java.util.Arrays;
import java.util.Comparator;

public class Sk_3 {
    public static void main(String[] args) {
//        System.out.println(solution(new int[][]{{1, 2}, {2, 3}}, new int[][]{{1, 3}, {3, 2}}, 1));
//        System.out.println(solution(new int[][]{{1, 2}, {3, 1}, {2, 4}, {3, 5}}, new int[][]{{2, 1}, {4, 1}, {2, 5}, {3, 2}}, 1));
//        System.out.println(solution(new int[][]{{3, 4}, {7, 2}, {5, 4}, {2, 3}, {6, 5}, {1, 2}}, new int[][]{{2, 1}, {3, 6}, {1, 4}, {1, 5}, {7, 1}, {3, 2}}, 2));
    }

    public static int solution(int[][] a, int[][] b, int m) {
        Arrays.sort(a, Comparator.comparing((int[] arr) -> arr[0]));
        Arrays.sort(b, Comparator.comparing((int[] arr) -> arr[0]));

        int answer = -1;
        return answer;
    }
}
