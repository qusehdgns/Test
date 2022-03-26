package com.gmoney.programmers.line_20220326;

public class Line_4 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 7, 2, 4}, new int[]{4, 5, 5, 2}));     // 3
        System.out.println(solution(new int[]{6, 2, 2, 6}, new int[]{4, 4, 4, 4}));     // 2
    }

    public static int solution(int[] arr, int[] brr) {
        int answer = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == brr[i])
                continue;

            int diff = arr[i] - brr[i];

            arr[i] = brr[i];
            arr[i + 1] += diff;

            answer++;
        }

        return answer;
    }
}
