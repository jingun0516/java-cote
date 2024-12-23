package programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Pm340212 {
    public static int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        int l = 1;
        int r = Arrays.stream(diffs).max().getAsInt();
        answer = r;

        while(l <= r) {
            int level = (l + r) / 2;
            long time = times[0];

            for(int i = 1; i < diffs.length; i++) {
                int time_prev = times[i - 1];
                int time_cur = times[i];

                if(level < diffs[i]) {
                    time += (long)(diffs[i] - level) * (time_cur + time_prev) + time_cur;
                } else {
                    time += time_cur;
                }

                if(time > limit) {
                    break;
                }
            }

            if(time <= limit) {
                answer = level;
                r = level - 1;
            } else {
                l = level + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] diffs = new int[n];
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            diffs[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            times[i] = sc.nextInt();
        }
        long limit = sc.nextLong();

        System.out.println(solution(diffs, times, limit));
    }
    // https://school.programmers.co.kr/learn/courses/30/lessons/340212
}


/*
당신은 순서대로 n개의 퍼즐을 제한 시간 내에 풀어야 하는 퍼즐 게임을 하고 있습니다.
각 퍼즐은 난이도와 소요 시간이 정해져 있습니다. 당신의 숙련도에 따라 퍼즐을 풀 때 틀리는 횟수가 바뀌게 됩니다.
현재 퍼즐의 난이도를 diff, 현재 퍼즐의 소요 시간을 time_cur,
이전 퍼즐의 소요 시간을 time_prev, 당신의 숙련도를 level이라 하면, 게임은 다음과 같이 진행됩니다.

diff ≤ level이면 퍼즐을 틀리지 않고 time_cur만큼의 시간을 사용하여 해결합니다.
diff > level이면, 퍼즐을 총 diff - level번 틀립니다. 퍼즐을 틀릴 때마다,
time_cur만큼의 시간을 사용하며, 추가로 time_prev만큼의 시간을 사용해 이전 퍼즐을 다시 풀고 와야 합니다.
이전 퍼즐을 다시 풀 때는 이전 퍼즐의 난이도에 상관없이 틀리지 않습니다.
diff - level번 틀린 이후에 다시 퍼즐을 풀면 time_cur만큼의 시간을 사용하여 퍼즐을 해결합니다.
예를 들어 diff = 3, time_cur = 2, time_prev = 4인 경우, level에 따라 퍼즐을 푸는데 걸리는 시간은 다음과 같습니다.

level = 1이면, 퍼즐을 3 - 1 = 2번 틀립니다. 한 번 틀릴 때마다 2 + 4 = 6의 시간을 사용하고,
다시 퍼즐을 푸는 데 2의 시간을 사용하므로 총 6 × 2 + 2 = 14의 시간을 사용하게 됩니다.
level = 2이면, 퍼즐을 3 - 2 = 1번 틀리므로, 6 + 2 = 8의 시간을 사용하게 됩니다.
level ≥ 3이면 퍼즐을 틀리지 않으며, 2의 시간을 사용하게 됩니다.
퍼즐 게임에는 전체 제한 시간 limit가 정해져 있습니다. 제한 시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟값을 구하려고 합니다.
난이도, 소요 시간은 모두 양의 정수며, 숙련도도 양의 정수여야 합니다.

퍼즐의 난이도를 순서대로 담은 1차원 정수 배열 diffs, 퍼즐의 소요 시간을 순서대로 담은 1차원 정수 배열 times,
전체 제한 시간 limit이 매개변수로 주어집니다. 제한 시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟값을 정수로 return 하도록 solution 함수를 완성해 주세요.
 */