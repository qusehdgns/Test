package com.gmoney.programmers.level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class GetTheReportResult {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"muzi", "frodo", "apeach", "neo"},
                new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2)));
        System.out.println(Arrays.toString(solution(new String[] {"con", "ryan"},
                new String[] {"ryan con", "ryan con", "ryan con", "ryan con"}, 3)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        List<String> idList = Arrays.asList(id_list);   // index 구하기 위한 List
        int[] reportedCount = new int[id_list.length];      // 신고당한 횟수, id_list 매핑
        LinkedHashSet<String>[] reportUserInfo = new LinkedHashSet[reportedCount.length];   // 신고자 피의자 매핑
        ArrayList<String> overReportedUser = new ArrayList<>();     // 초과 신고자 정보

        // ArrayList 배열 초기화
        Arrays.setAll(reportUserInfo, LinkedHashSet::new);

        Arrays.stream(report).forEach(report_info -> {
            String[] report_arr = report_info.split(" ");

            // 신고자의 피의자 정보 기록
            reportUserInfo[idList.indexOf(report_arr[0])].add(report_arr[1]);
        });

        Arrays.stream(reportUserInfo).forEach(reportInfo
                -> reportInfo.forEach(user -> reportedCount[idList.indexOf(user)]++));

        // 초과 피의자 기록
        for (int i = 0; i < reportedCount.length; i++)
            if(reportedCount[i] >= k)
                overReportedUser.add(id_list[i]);

        int[] answer = Arrays.stream(reportUserInfo).mapToInt(reportInfo
                -> (int) overReportedUser.stream().filter(user
                    -> reportInfo.contains(user)).count()).toArray();

        return answer;
    }
}
