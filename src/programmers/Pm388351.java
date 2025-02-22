package programmers;

public class Pm388351 {
    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < schedules.length; i++) {
            schedules[i] = schedules[i] / 100 * 60 + schedules[i] % 100 + 10;
        }

        for (int i = 0; i < timelogs.length; i++) {
            int day = startday - 1;

            for (int j = 0; j < timelogs[i].length; j++) {
                day++;
                timelogs[i][j] = timelogs[i][j] / 100 * 60 + timelogs[i][j] % 100;
                if (timelogs[i][j] > schedules[i]) {
                    if(day % 7 != 6 && day % 7 != 0) {
                        break;
                    }
                }
                if (j == timelogs[i].length - 1) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] schedules = new int[]{730, 855, 700, 720};
        int[][] timelogs = new int[][]
                {
                        {710, 700, 650, 735, 700, 931, 912},
                        {908, 901, 805, 815, 800, 831, 835},
                        {705, 701, 702, 705, 710, 710, 711},
                        {707, 731, 859, 913, 934, 931, 905}
                };
        int startday = 1;

        System.out.println(solution(schedules, timelogs, startday));
    }
}

/*
프로그래머스 사이트를 운영하는 그렙에서는 재택근무와 함께 출근 희망 시각을 자유롭게 정하는 유연근무제를 시행하고 있습니다.
제도 정착을 위해 오늘부터 일주일 동안 각자 설정한 출근 희망 시각에 늦지 않고 출근한 직원들에게 상품을 주는 이벤트를 진행하려고 합니다.

직원들은 일주일동안 자신이 설정한 출근 희망 시각 + 10분까지 어플로 출근해야 합니다.
예를 들어 출근 희망 시각이 9시 58분인 직원은 10시 8분까지 출근해야 합니다.
단, 토요일, 일요일의 출근 시각은 이벤트에 영향을 끼치지 않습니다. 직원들은 매일 한 번씩만 어플로 출근하고,
모든 시각은 시에 100을 곱하고 분을 더한 정수로 표현됩니다. 예를 들어 10시 13분은 1013이 되고 9시 58분은 958이 됩니다.

당신은 직원들이 설정한 출근 희망 시각과 실제로 출근한 기록을 바탕으로 상품을 받을 직원이 몇 명인지 알고 싶습니다.

직원 n명이 설정한 출근 희망 시각을 담은 1차원 정수 배열 schedules,
직원들이 일주일 동안 출근한 시각을 담은 2차원 정수 배열 timelogs,
이벤트를 시작한 요일을 의미하는 정수 startday가 매개변수로 주어집니다.

이때 상품을 받을 직원의 수를 return 하도록 solution 함수를 완성해주세요.
 */