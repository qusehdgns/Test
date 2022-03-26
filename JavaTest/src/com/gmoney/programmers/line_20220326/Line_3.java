package com.gmoney.programmers.line_20220326;

import java.util.*;

public class Line_3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3,      // [1,4,5,7]
                new String[]{"development", "marketing", "hometask"},
                new String[]{"recruitment", "education", "officetask"},
                new String[]{"1 development hometask", "1 recruitment marketing", "2 hometask", "2 development marketing hometask", "3 marketing", "3 officetask", "3 development"})));
        System.out.println(Arrays.toString(solution(2,      // [3,4]
                new String[]{"design"},
                new String[]{"building", "supervise"},
                new String[]{"2 design", "1 supervise building design", "1 design", "2 design"})));
    }

    public static int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        Map<Integer, List<Map<Integer, String[]>>> info = new HashMap<>();
        ArrayList<Map<Integer, String[]>>[] employeesInfo = new ArrayList[num_teams];

        Arrays.setAll(employeesInfo, ArrayList::new);

        for (int i = 0; i < employees.length; i++) {
            String[] splitArr = employees[i].split(" ");

            employeesInfo[Integer.parseInt(splitArr[0]) - 1].add(Map.of(i + 1, Arrays.copyOfRange(splitArr, 1, splitArr.length)));
        }

        for (int i = 0; i < employeesInfo.length; i++) {
            info.put(i + 1, employeesInfo[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= num_teams; i++) {
            ArrayList<Integer> team_office_worker = new ArrayList<>();
            ArrayList<Integer> team_remote_worker = new ArrayList<>();
            for (Map<Integer, String[]> employee : info.get(i)) {
                for (Integer key : employee.keySet()) {
                    String[] tasks = employee.get(key);

                    boolean remote_user = true;

                    for (int j = 0; j < tasks.length; j++) {
                        if (Arrays.asList(office_tasks).contains(tasks[j])) {
                            remote_user = false;
                            break;
                        }
                    }

                    if (remote_user)
                        team_remote_worker.add(key);
                    else
                        team_office_worker.add(key);
                }
            }

            if (team_office_worker.size() == 0) {
                team_remote_worker.remove(0);
            }

            result.addAll(team_remote_worker);
        }

        int[] answer = result.stream().sorted().mapToInt(value -> value).toArray();
        return answer;
    }
}
