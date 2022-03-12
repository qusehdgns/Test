package com.gmoney.programmers.sk_20220312;

import java.util.*;

public class Sk_4 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[][] {{0,1},{0,2},{1,3},{1,4}}));
        System.out.println(solution(4, new int[][] {{2,3},{0,1},{1,2}}));
    }

    public static long solution(int n, int[][] edges) {
        int[][] adjArr = new int[n + 1][n + 1];

        long answer = 0;

        Arrays.stream(edges).forEach(arr -> {
            adjArr[arr[0] + 1][arr[1] + 1] = 1;
            adjArr[arr[1] + 1][arr[0] + 1] = 1;
        });

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if(i == j || j == k || i == k)
                        continue;

                    if(getMinDistance(i, j, adjArr) > 0 && getMinDistance(j, k, adjArr) > 0 && getMinDistance(i, k, adjArr) > 0) {
                        if(getMinDistance(i, j, adjArr) + getMinDistance(j, k, adjArr) == getMinDistance(i, k, adjArr))
                            answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static long getMinDistance(int start, int end, int[][] adjArr) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adjArr.length];
        ArrayList<Long> distanceArr = new ArrayList<>();

        dfs_allPathDistance(start, end, stack, adjArr, visited, distanceArr);

        if(distanceArr.size() > 0)
            return Collections.min(distanceArr);
        else
            return 0;
    }

    public static void dfs_allPathDistance(int start, int end, Stack<Integer> stack, int[][] adjArr, boolean[] visited, ArrayList<Long> distanceArr) {
        visited[start] = true;

        stack.push(start);

        if(start == end) {
            distanceArr.add((long) (stack.size() - 1));
        }

        for(int i = 1; i <= adjArr.length-1; i++) {
            if(adjArr[start][i] == 1 && !visited[i]) {
                dfs_allPathDistance(i, end, stack, adjArr, visited, distanceArr);

                visited[i] = false;
            }
        }

        stack.pop();
    }
}
