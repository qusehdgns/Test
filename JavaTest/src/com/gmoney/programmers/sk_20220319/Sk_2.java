package com.gmoney.programmers.sk_20220319;

import java.util.ArrayList;
import java.util.Arrays;

public class Sk_2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[]{"1", "2", "4", "3", "3", "4", "1", "5"}, new String[]{"read 1 3 1 2", "read 2 6 4 7", "write 4 3 3 5 2", "read 5 2 2 5", "write 6 1 3 3 9", "read 9 1 0 7"})));
        System.out.println(Arrays.toString(
                solution(new String[]{"1", "1", "1", "1", "1", "1", "1"}, new String[]{"write 1 12 1 5 8", "read 2 3 0 2", "read 5 5 1 2", "read 7 5 2 5", "write 13 4 0 1 3", "write 19 3 3 5 5", "read 30 4 0 6", "read 32 3 1 5"})));
    }

    public static String[] solution(String[] arr, String[] processes) {
        int readOrder = 0;

        for (int i = 0; i < processes.length; i++) {
            if (processes[i].indexOf("read") != -1) {
                processes[i] = processes[i] + " " + readOrder++;
            }
        }

        String[] answer = new String[readOrder + 1];

        ArrayList<String[]> processesList = new ArrayList<>();
        Arrays.stream(processes).forEach(process -> processesList.add(process.split(" ")));

        ArrayList<String[]> processing = new ArrayList<>();
        ArrayList<String[]> waiting_read = new ArrayList<>();
        ArrayList<String[]> waiting_write = new ArrayList<>();

        int processTime = 0;
        int time = 0;

        while (true) {
            time++;

            if (processing.size() != 0) {
                processTime++;

                for (int i = processing.size() - 1; i >= 0; i--) {
                    String[] process = processing.get(i);

                    if (Integer.parseInt(process[1]) + Integer.parseInt(process[2]) == time) {
                        processing.remove(i);

                        int startIdx = Integer.parseInt(process[3]);
                        int endIdx = Integer.parseInt(process[4]);

                        if (process[0].equalsIgnoreCase("read")) {
                            answer[Integer.parseInt(process[5])] = String.join("", Arrays.copyOfRange(arr, startIdx, endIdx + 1));
                        } else {
                            for (int j = startIdx; j <= endIdx; j++) {
                                arr[j] = process[5];
                            }
                        }
                    }
                }
            }

            if (processesList.size() != 0) {
                if(processing.size() == 0 && waiting_write.size() == 0 && waiting_read.size() == 0)
                    time = Integer.parseInt(processesList.get(0)[1]);

                if (processesList.get(0)[1].equals(Integer.toString(time))) {
                    String[] timeProcess = processesList.remove(0);

                    if (timeProcess[0].equalsIgnoreCase("read")) {
                        waiting_read.add(timeProcess);
                    } else {
                        waiting_write.add(timeProcess);
                    }
                }
            }


            if (processing.size() == 0) {
                if (processesList.size() == 0 && waiting_write.size() == 0 && waiting_read.size() == 0) {
                    break;
                } else {
                    if (waiting_write.size() != 0) {
                        String[] nextProcess = waiting_write.remove(0);

                        nextProcess[1] = Integer.toString(time);

                        processing.add(nextProcess);
                    } else if (waiting_read.size() != 0) {
                        while (waiting_read.size() != 0) {
                            String[] nextProcess = waiting_read.remove(0);

                            nextProcess[1] = Integer.toString(time);

                            processing.add(nextProcess);
                        }
                    }
                }
            } else {
                if(processing.get(0)[0].equalsIgnoreCase("read")) {
                    if (waiting_read.size() != 0 && waiting_write.size() == 0) {
                        while (waiting_read.size() != 0) {
                            String[] nextProcess = waiting_read.remove(0);

                            nextProcess[1] = Integer.toString(time);

                            processing.add(nextProcess);
                        }
                    }
                }
            }
        }

        answer[answer.length - 1] = Integer.toString(processTime);

        return answer;
    }
}
