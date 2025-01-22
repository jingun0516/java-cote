package baekjoon.needcheck;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bj16236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, -1, 0, 1};

        int N = sc.nextInt();

        int[][] maps = new int[N][N];
        int nowY = 0, nowX = 0;
        int sharkSize = 2;  // 아기 상어 크기

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maps[i][j] = sc.nextInt();
                if (maps[i][j] == 9) {
                    nowY = i;
                    nowX = j;
                    maps[i][j] = 0;
                }
            }
        }

        int answer = 0;
        int fishEaten = 0;

        while (true) {
            int[][] dist = new int[N][N];  // 각 칸까지의 거리를 저장할 배열
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], -1);  // 초기값 -1로 설정
            }

            Queue<int[]> qu = new LinkedList<>();
            qu.add(new int[]{nowY, nowX});
            dist[nowY][nowX] = 0;

            int foundY = -1, foundX = -1;  // 먹을 물고기의 위치
            int minDist = Integer.MAX_VALUE;

            while (!qu.isEmpty()) {
                int[] cur = qu.poll();
                int y = cur[0];
                int x = cur[1];

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= N || dist[ny][nx] != -1 || maps[ny][nx] > sharkSize) {
                        continue;
                    }

                    dist[ny][nx] = dist[y][x] + 1;

                    if (maps[ny][nx] > 0 && maps[ny][nx] < sharkSize) {
                        // 먹을 수 있는 물고기 발견
                        if (dist[ny][nx] < minDist ||
                                (dist[ny][nx] == minDist && (ny < foundY || (ny == foundY && nx < foundX)))) {
                            minDist = dist[ny][nx];
                            foundY = ny;
                            foundX = nx;
                        }
                    }

                    qu.add(new int[]{ny, nx});
                }
            }

            // 먹을 수 있는 물고기를 찾지 못한 경우
            if (foundY == -1 && foundX == -1) {
                break;
            }

            // 물고기를 먹은 위치로 이동
            answer += minDist;
            nowY = foundY;
            nowX = foundX;
            maps[nowY][nowX] = 0;
            fishEaten++;

            if (fishEaten == sharkSize) {
                sharkSize++;
                fishEaten = 0;
            }
        }

        System.out.println(answer);
    }
}
