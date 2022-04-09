package com.gmoney.programmers.todaysHome_20220409;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 템플릿 문자열이란, 문자열 안에 존재하는 변수를 사용해 문자열을 작성하고, 실제 사용할 때 변수에 값을 대입해 사용하는 문자열을 말합니다.
 * <p>
 * 다음과 같은 문자열이 있다고 가정해 보겠습니다.
 * <p>
 * this is {template}
 * {template} is {state}
 * 문자열에 존재하는 {}로 감싼 단어들은 모두 변수입니다. 위 예시에서는 {template}과 {state} 두 변수가 있습니다.
 * 이 문자열을 실제로 사용하기 위해서는 {template}과 {state}에 특정 값을 대입해 사용해야 합니다.
 * 아래 표처럼 변수에 값을 대입하면 다음과 같은 문자열이 됩니다.
 * <p>
 * 변수	값
 * template	string
 * state	changed
 * this is string
 * string is changed
 * 아래 표의 값을 변수에 대입하면 다음과 같은 문자열이 됩니다.
 * <p>
 * 변수	값
 * template	string
 * state	{template}
 * this is string
 * string is {template}
 * 모든 변수에 값을 대입한 뒤 새로운 변수가 있다면, 변수가 없어질 때까지 대입해야 합니다. 따라서 결과는 아래와 같습니다.
 * <p>
 * this is string
 * string is string
 * 아래 표의 값을 변수에 대입하면, 변수에 값을 대입하는 과정이 무한히 반복됩니다.
 * <p>
 * 변수	값
 * template	{state}
 * state	{template}
 * 이와 같이 무한히 반복하며 변수를 대입해야 할 경우 변수에 값을 대입하지 않고 종료합니다. 따라서 결과는 아래와 같습니다.
 * <p>
 * this is {template}
 * {template} is {state}
 * 템플릿 문자열 tstring과 변수와 값을 담은 2차원 문자열 배열 variables가 주어졌을 때, 변수에 값을 대입한 결과 문자열을 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 단, variables에 없는 변수에는 값을 대입하지 않습니다.
 */
public class TodaysHome_3 {
    public static void main(String[] args) {
        System.out.println(         // "this is string string is changed"
                solution("this is {template} {template} is {state}", new String[][]{{"template", "string"}, {"state", "changed"}}));
        System.out.println(         // "this is string string is string"
                solution("this is {template} {template} is {state}", new String[][]{{"template", "string"}, {"state", "{template}"}}));
        System.out.println(         // "this is {template} {template} is {state}"
                solution("this is {template} {template} is {state}", new String[][]{{"template", "{state}"}, {"state", "{template}"}}));
        System.out.println(         // "this is {templates} {templates} is {templates}"
                solution("this is {template} {template} is {state}", new String[][]{{"template", "{state}"}, {"state", "{templates}"}}));
        System.out.println(         // "d d d {d} {i}"
                solution("{a} {b} {c} {d} {i}", new String[][]{{"b", "{c}"}, {"a", "{b}"}, {"e", "{f}"}, {"h", "i"}, {"d", "{e}"}, {"f", "{d}"}, {"c", "d"}}));
    }

    public static String solution(String tstring, String[][] variables) {
        String answer = tstring;
        ArrayList<String> record = new ArrayList<>(Arrays.asList(tstring));

        while (checkString(answer, variables)) {
            answer = replaceOnce(answer, variables);

            if (record.contains(answer))
                break;

            record.add(answer);
        }

        return answer;
    }

    public static boolean checkString(String value, String[][] variables) {
        for (int i = 0; i < variables.length; i++) {
            if (value.contains(String.format("{%s}", variables[i][0])))
                return true;
        }

        return false;
    }

    public static String replaceOnce(String string, String[][] variables) {
        String[] splitString = string.split("");

        for (int i = 0; i < variables.length; i++) {
            String[] splitVariable = variables[i][0].split("");

            boolean check = false;
            int startIdx = 0;
            int idx = 0;
            for (int j = 0; j < splitString.length; j++) {
                if (!check) {
                    if ("{".equals(splitString[j])) {
                        check = true;
                        idx = 0;
                        startIdx = j;
                    }
                } else {
                    if (idx > splitString.length) {
                        check = false;
                    } else if (idx == splitVariable.length) {
                        if ("}".equals(splitString[j])) {
                            ArrayList<String> temp = new ArrayList<>();

                            Collections.addAll(temp, Arrays.copyOf(splitString, startIdx));
                            Collections.addAll(temp, new String[]{variables[i][1]});

                            if (j + 1 < splitString.length) {
                                Collections.addAll(temp, Arrays.copyOfRange(splitString, j + 1, splitString.length));
                            }

                            j = j - (splitString.length - temp.size());
                            splitString = temp.toArray(new String[temp.size()]);
                        }
                        check = false;
                    } else if (!splitString[j].equals(splitVariable[idx])) {
                        check = false;
                    }

                    idx++;
                }
            }
        }

        return String.join("", splitString);
    }
}