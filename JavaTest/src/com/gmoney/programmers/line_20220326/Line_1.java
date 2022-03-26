package com.gmoney.programmers.line_20220326;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Line_1 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]        // 3
                {"team_name : db application_name : dbtest error_level : info message : test",
                        "team_name : test application_name : I DONT CARE error_level : error message : x",
                        "team_name : ThisIsJustForTest application_name : TestAndTestAndTestAndTest error_level : test message : IAlwaysTestingAndIWillTestForever",
                        "team_name : oberervability application_name : LogViewer error_level : error"}));
        System.out.println(solution(new String[]        // 6
                {"team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange",
                        "no such file or directory",
                        "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11",
                        "team_name : recommend application_name : recommend error_level : info message : Success!",
                        "   team_name : db application_name : dbtest error_level : info message : test",
                        "team_name     : db application_name : dbtest error_level : info message : test",
                        "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"}));
    }

    public static int solution(String[] logs) {
        int answer = (int) Arrays.stream(logs).filter(log -> {
            boolean result = log.length() > 100;

            if (!result) {
                String[] logSplit = log.split(" ");

                if (logSplit.length != 12) {
                    result = true;
                } else {
                    String[] titles = new String[]{"team_name", "application_name", "error_level", "message"};
                    String pattern = "^[a-zA-Z]*$";

                    for (int i = 0; i < logSplit.length; i++) {
                        switch (i % 3) {
                            case 0:
                                result = !Arrays.asList(titles).contains(logSplit[i]);
                                break;
                            case 1:
                                result = !":".equals(logSplit[i]);
                                break;
                            case 2:
                                result = !Pattern.matches(pattern, logSplit[i]);
                                break;
                            default:
                                break;
                        }

                        if (result) {
                            break;
                        }
                    }
                }
            }

            return result;
        }).count();

        return answer;
    }
}
