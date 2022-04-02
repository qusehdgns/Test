package com.gmoney.programmers.devMatching_20220402;


/**
 * 격자가 있습니다. 격자의 각 칸에는 'a', 'b', 'c', 또는 '?'가 쓰여 있습니다.
 * 당신은 '?'가 들어있는 모든 칸에서 '?'를 지우고 'a', 'b', 또는 'c'를 적어서, 같은 글자가 써진 칸끼리 상하좌우로 전부 연결하고 싶습니다.
 * 예를 들어, 격자 내에 ‘a’가 총 3개 있다면 3개의 ‘a’가 모두 상하좌우로 연결되어야 합니다. ‘b’, ‘c’가 있다면 마찬가지로 각각 모두 연결되어야 합니다.
 *
 * 격자를 나타내는 1차원 문자열 배열 grid가 매개변수로 주어집니다.
 * '?'를 'a', 'b', 또는 'c'로 바꾸어서 같은 글자를 가지고 있는 칸끼리는 상하좌우로 전부 연결되도록 하는 모든 경우의 수를 return 하도록 solution 함수를 완성해주세요.
 */

public class DevMatching_2 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"??b", "abc", "cc?"}));                // 2
        System.out.println(solution(new String[]{"abcabcab","????????"}));              // 0
        System.out.println(solution(new String[]{"aa?"}));                              // 3
    }

    public static int solution(String[] grid) {
        int answer = -1;
        return answer;
    }
}
