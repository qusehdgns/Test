package com.gmoney.programmers.devMatching_20220402;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 수직선 위에 놓인 점들 사이의 거리가 주어질 때, 각 점들이 어떤 순서로 놓여있는지 알아보려 합니다.
 *
 * 다음은 점 5개가 주어질 때, 각 점 사이의 거리를 나타낸 행렬입니다.
 *
 * dots_1.png
 *
 * i행 j열은 i번 점과 j번 점 사이의 거리를 나타냅니다.
 * 위 행렬을 만족하도록 수직선 위에 점을 놓는 방법은 다음과 같이 두 가지가 있습니다.
 *
 * dots_3.png
 *
 * dots_2.png
 *
 * 예를 들면, 2번 점과 4번 점 사이의 거리는 2행 4열(또는 4행 2열)의 값이며, 이는 3입니다.
 * 그림에서도 마찬가지로 2번점과 4번점 사이의 거리가 1 + 2 = 3이며, 이는 행렬의 값과 동일합니다.
 * 그림에 표시된 점에 대해서 서로 다른 두 점 사이의 거리는 모두 행렬의 값을 만족합니다.
 *
 * 따라서 수직선 위에 놓인 점의 순서는 [1번, 2번, 0번, 4번 3번] 또는 [3번, 4번, 0번, 2번, 1번]이 되며, 이 외에 행렬에서 주어진 점 사이의 거리 값을 모두 만족하도록 점을 놓는 방법은 없습니다.
 *
 * 두 점 사이의 거리를 행렬 형태로 나타낸 2차원 정수 배열 dist가 매개변수로 주어집니다.
 * 행렬의 값을 만족하도록 수직선 위에 점을 놓는 모든 방법에 대해서 점의 순서를 왼쪽부터 차례대로 담아 2차원 배열 형태로 return 하도록 solution 함수를 완성해주세요.
 */

public class DevMatching_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(             // [[1,2,0,4,3],[3,4,0,2,1]]
                solution(new int[][]{{0, 5, 2, 4, 1}, {5, 0, 3, 9, 6}, {2, 3, 0, 6, 3}, {4, 9, 6, 0, 3}, {1, 6, 3, 3, 0}})));
        System.out.println(Arrays.deepToString(             // [[0,3,1,2],[2,1,3,0]]
                solution(new int[][]{{0, 2, 3, 1}, {2, 0, 1, 1}, {3, 1, 0, 2}, {1, 1, 2, 0}})));
    }

    public static int[][] solution(int[][] dist) {
        ArrayList<int[]> result = new ArrayList<>();
        ArrayList<int[]> values = new ArrayList<>();

        permutation(IntStream.range(0, dist.length).toArray(), 0, values);

        System.out.println(values.size());

        for(int[] temp: values) {
            if(solve(temp, dist))
                result.add(temp);
        }

        int[][] answer = convert(result);
        return answer;
    }

    public static int[][] convert(List<int[]> input) {
        int[][] output = new int[input.size()][];

        for (int i = 0; i < output.length; i++) {
            output[i] = input.get(i);
        }

        return output;
    }

    public static boolean solve(int[] temp, int[][] dist) {
        for (int i = 1; i < temp.length; i++) {
            int sum = 0;

            for (int j = 1; j <= i; j++) {
                sum += dist[temp[j-1]][temp[j]];
            }

            if(sum != dist[temp[0]][temp[i]])
                return false;
        }

        return true;
    }

    public static void permutation(int[] arr, int depth, ArrayList<int[]> result) {
        if (depth == arr.length) {
            result.add(arr.clone());
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            if(i == depth) {
                permutation(arr, depth + 1, result);
            } else {
                swap(arr, depth, i);
                permutation(arr, depth + 1, result);
                swap(arr, depth, i);
            }
        }
    }

    public static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}