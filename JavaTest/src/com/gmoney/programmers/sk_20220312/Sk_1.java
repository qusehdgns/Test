package com.gmoney.programmers.sk_20220312;

import java.util.Arrays;

public class Sk_1 {
    public static void main(String[] args) {
        System.out.println(solution(4578, new int[] {1, 4, 99, 35, 50, 1000}));
        System.out.println(solution(1999, new int[] {2, 11, 20, 100, 200, 600}));
    }

    public static int solution(int money, int[] costs) {
        int[] money_arr = {1, 5, 10, 50, 100, 500};

        int[] val_arr = new int[money_arr.length];

        for (int i = money_arr.length - 1; i >= 0; i--)
            val_arr[i] = (money_arr[i] - costs[i]) * (500 / money_arr[i]);

        sortDescTogether(val_arr, money_arr, costs);

        int[] count_arr = new int[val_arr.length];

        for (int i = 0; i < money_arr.length; i++) {
            if(money <= 0)
                break;

            count_arr[i] = money / money_arr[i];
            money -= (count_arr[i] * money_arr[i]);
        }

        int[] cost_arr = new int[count_arr.length];

        for (int i = 0; i < cost_arr.length; i++)
            cost_arr[i] = costs[i] * count_arr[i];

        int answer = Arrays.stream(cost_arr).sum();

        return answer;
    }

    public static void sortDescTogether(int[] main_arr, int[] sub_arr_1, int[] sub_arr_2) {
        for (int i = 1; i < main_arr.length; i++) {
            for (int j = 0; j < main_arr.length - i; j++) {
                if (main_arr[j] <= main_arr[j + 1]) {
                    swap(main_arr, j, j + 1);
                    swap(sub_arr_1, j, j + 1);
                    swap(sub_arr_2, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
