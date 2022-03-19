package com.gmoney.programmers.sk_20220319;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class Sk_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"pencil", "cilicon", "contrabase", "picturelist"})));
        System.out.println(Arrays.toString(solution(new String[] {"abcdeabcd","cdabe","abce","bcdeab"})));
    }

    public static String[] solution(String[] goods) {
        String[] answer = new String[goods.length];
        LinkedHashSet<String>[] keywordList = new LinkedHashSet[goods.length];

        Arrays.setAll(keywordList, LinkedHashSet::new);

        for (int i = 0; i < goods.length; i++) {
            int goodLength = goods[i].length();

            for (int j = 1; j <= goodLength; j++) {
                if (keywordList[i].size() > 0)
                    break;

                for (int k = 0; k <= goodLength - j; k++) {
                    String keyword = goods[i].substring(k, k + j);
                    boolean unique = true;

                    for (int l = 0; l < goods.length; l++) {
                        if (i == l)
                            continue;

                        if (goods[l].indexOf(keyword) != -1) {
                            unique = false;
                            break;
                        }
                    }

                    if (unique) {
                        keywordList[i].add(keyword);
                    }
                }
            }
        }

        for (int i = 0; i < keywordList.length; i++)
            answer[i] = keywordList[i].size() > 0 ?
//                  keywordList[i].stream().sorted().collect(Collectors.joining(" "))
                    Arrays.toString(keywordList[i].stream().sorted().toArray()).replaceAll(",", "").replace("[", "").replace("]", "")
                    : "None";

        return answer;
    }
}
