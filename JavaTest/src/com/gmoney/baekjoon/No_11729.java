package com.gmoney.baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
 *
 * 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 * 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 * 이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
 *
 * 아래 그림은 원판이 5개인 경우의 예시이다.
 *
 * https://www.acmicpc.net/problem/11729
 */
public class No_11729 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;
        Stack<Integer>[] values = new Stack[] {new Stack<>(), new Stack<>(), new Stack<>()};

        IntStream.range(1, n + 1).boxed().sorted(Collections.reverseOrder()).forEach(num -> values[0].push(num));

        System.out.println(Arrays.toString(values));
    }

    public static int move(Stack<Integer>[] values, int n, int count) {
        if(values[2].size() == n) {
            return count;
        }

        // TODO
        return 0;
    }
}
