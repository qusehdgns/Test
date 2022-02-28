/**
 * 조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.
 *
 * https://www.acmicpc.net/problem/1002
 *
 * 이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
 *
 * 조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
 */
package com.gmoney.baekjoon.basicMath_9;

import java.util.Scanner;

public class No_1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int track = sc.nextInt();

        for (int i = 0; i < track; i++) {
            int x1 = sc.nextInt(), y1 = sc.nextInt(), r1 = sc.nextInt();
            int x2 = sc.nextInt(), y2 = sc.nextInt(), r2 = sc.nextInt();

            double len = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));

            int result = 2;

            if(len == 0 && r1 == r2)
                result = -1;
            else if(r1 + r2 == len || r2 + len == r1 || r1 + len == r2)
                result = 1;
            else if(r1 + r2 < len || r2 + len < r1 || r1 + len < r2)
                result = 0;

            System.out.println(result);
        }
    }
}
