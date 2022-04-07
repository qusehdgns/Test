package com.gmoney.arrayListSubList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> temp = new ArrayList<>();

        for (int i = 0; i < 1001; i++) {
            temp.add(Integer.toString(i));
        }

        for (int i = 0; i < (temp.size()/50) + ((temp.size() % 50) > 0 ? 1 : 0); i++) {
            List<String> list;

            try {
                int endIdx = ((i + 1) * 50);

                list = new ArrayList<>(temp.subList((i * 50), endIdx > temp.size() ? temp.size() : endIdx));

                System.out.println(list.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
