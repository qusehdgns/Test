package com.gmoney.programmers.todaysHome_20220409;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 음성 인식 기술을 사용하면 사람이 말하는 음성 데이터를 문자 데이터로 변환할 수 있습니다.
 * 당신은 오늘의집에 전화로 들어온 주문을 자동으로 처리하기 위해, 음성 데이터를 문자 데이터로 변환하려 합니다.
 * 당신은 이 문자 데이터를 쓰기 전에 먼저 반복적으로 사용된 말버릇 패턴을 삭제해야 합니다.
 * 말버릇 패턴이란 문자 데이터에서 가장 많이 등장하는 길이 1 이상의 패턴이며, 문자 데이터에 등장하는 해당 패턴을 모두 삭제하면 됩니다.
 * 단, 이러한 패턴은 대소문자를 구분하지 않으며, 가장 많이 등장한 패턴이 여러 개일 경우 그러한 패턴을 모두 삭제합니다.
 * <p>
 * 다음은 문자 데이터에서 말버릇 패턴을 삭제하는 예시입니다.
 * <p>
 * 삭제 전	삭제 후
 * "abcabcdefabc"	"def"
 * "abxdeydeabz"	"xyz"
 * "abcabcdefabc"에서 "abc"가 3번 등장하며, 가장 많이 등장한 패턴입니다. "abc"를 삭제하면 "def"가 남게 됩니다.
 * "abxdeydeabz"에서 "ab"와 "de"가 2번 등장하며, 가장 많이 등장한 패턴입니다. "ab"와 "de"를 삭제하면 "xyz"가 남게 됩니다.
 * 음성 데이터를 문자 데이터로 변환한 문자열 call이 매개변수로 주어집니다. 이때, 가장 많이 등장한 말버릇을 삭제한 결과를 문자열로 return 하도록 solution 함수를 완성해주세요.
 */
public class TodaysHome_2 {
    public static void main(String[] args) {
        System.out.println(solution("abcabcdefabc"));       // "def"
        System.out.println(solution("abxdeydeabz"));       // "xyz"
        System.out.println(solution("abcabca"));       // "bcbc"
        System.out.println(solution("ABCabcA"));       // "BCbc"
    }

    public static String solution(String call) {
        String[] splitCall = call.split("");

        Map<String, Integer> info = new HashMap<>();

        for (int i = 1; i <= splitCall.length; i++) {
            for (int j = 0; j + i <= splitCall.length; j++) {
                String key = String.join("", Arrays.copyOfRange(splitCall, j, j + i));

                if (!info.keySet().contains(key.toLowerCase())) {
                    info.put(key.toLowerCase(), countWord(call, key));
                }
            }
        }

        Integer maxCount = Collections.max(info.values());

        String[] keys = info.entrySet().stream().filter(temp -> temp.getValue() == maxCount).map(temp -> temp.getKey()).toArray(String[]::new);

        for (String key : keys)
            call = call.replaceAll("(?i)" + key, "");

        return call;
    }

    public static Integer countWord(String string, String key) {
        return (string.length() - string.replaceAll("(?i)" + key, "").length()) / key.length();
    }
}
