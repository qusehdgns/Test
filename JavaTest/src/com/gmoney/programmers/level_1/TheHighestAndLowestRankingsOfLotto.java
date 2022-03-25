package com.gmoney.programmers.level_1;

import java.util.Arrays;

public class TheHighestAndLowestRankingsOfLotto {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19})));
        System.out.println(Arrays.toString(solution(new int[] {0, 0, 0, 0, 0, 0}, new int[] {38, 19, 20, 40, 15, 25})));
        System.out.println(Arrays.toString(solution(new int[] {45, 4, 35, 20, 3, 9}, new int[] {20, 9, 3, 45, 4, 35})));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int correctCount = (int) Arrays.stream(win_nums).filter(num -> Arrays.stream(lottos).anyMatch(i -> num == i)).count();
        int zeroCount = (int) Arrays.stream(lottos).filter(num -> num == 0).count();

        int highestRank = (7 - (correctCount + zeroCount));
        int lowestRank = (7 - correctCount);

        int[] answer = {highestRank > 6 ? 6 : highestRank, lowestRank > 6 ? 6 : lowestRank};

        return answer;
    }
}
