package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bj12851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<int[]> qu = new LinkedList<>();
        int[] dist = new int[100001]; // 방문 여부 및 최단 거리 저장
        Arrays.fill(dist, -1);

        qu.add(new int[]{N, 0});
        dist[N] = 0; // 시작점 방문 처리

        int minTime = Integer.MAX_VALUE;
        int answer = 0;

        while (!qu.isEmpty()) {
            int[] arr = qu.poll();
            int now = arr[0];
            int cnt = arr[1];

            if (now == K) {
                if (cnt < minTime) {
                    minTime = cnt;
                    answer = 1;
                } else if (cnt == minTime) {
                    answer++;
                }
                continue;
            }

            // 이동 가능한 위치들
            int[] nextPositions = {now + 1, now - 1, now * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000) {
                    if (dist[next] == -1 || dist[next] == cnt + 1) {
                        dist[next] = cnt + 1;
                        qu.add(new int[]{next, cnt + 1});
                    }
                }
            }
        }

        System.out.println(minTime);
        System.out.println(answer);
    }
}
