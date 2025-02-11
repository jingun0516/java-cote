package baekjoon.needcheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bj17144 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int R, C, T;
    static int[][] air;

    public static boolean check(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }

    public static void spreadDust() {
        int[][] temp = new int[R][C];

        // 기존 공기청정기 위치 복사
        for (int i = 0; i < R; i++) {
            System.arraycopy(air[i], 0, temp[i], 0, C);
        }

        // 먼지 확산
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (air[i][j] > 0) {
                    int additionalDust = air[i][j] / 5;
                    int count = 0;

                    for (int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];

                        if (check(ny, nx) && air[ny][nx] != -1) {
                            temp[ny][nx] += additionalDust;
                            count++;
                        }
                    }

                    temp[i][j] -= additionalDust * count; // 자기 자신에서 감소
                }
            }
        }

        // temp를 air로 갱신
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (air[i][j] != -1) { // 공기청정기는 유지
                    air[i][j] = temp[i][j];
                }
            }
        }
    }

    public static void cleanDust(int upperY, int lowerY) {
        // 상단 공기청정기 (반시계 방향)
        for (int y = upperY - 1; y > 0; y--) {
            air[y][0] = air[y - 1][0];
        }
        for (int x = 0; x < C - 1; x++) {
            air[0][x] = air[0][x + 1];
        }
        for (int y = 0; y < upperY; y++) {
            air[y][C - 1] = air[y + 1][C - 1];
        }
        for (int x = C - 1; x > 1; x--) {
            air[upperY][x] = air[upperY][x - 1];
        }
        air[upperY][1] = 0; // 공기청정기 바람 나가는 곳 초기화

        // 하단 공기청정기 (시계 방향)
        for (int y = lowerY + 1; y < R - 1; y++) {
            air[y][0] = air[y + 1][0];
        }
        for (int x = 0; x < C - 1; x++) {
            air[R - 1][x] = air[R - 1][x + 1];
        }
        for (int y = R - 1; y > lowerY; y--) {
            air[y][C - 1] = air[y - 1][C - 1];
        }
        for (int x = C - 1; x > 1; x--) {
            air[lowerY][x] = air[lowerY][x - 1];
        }
        air[lowerY][1] = 0; // 공기청정기 바람 나가는 곳 초기화
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();

        air = new int[R][C];
        List<Integer> airPurifier = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                air[i][j] = sc.nextInt();
                if (air[i][j] == -1) {
                    airPurifier.add(i);
                }
            }
        }

        int upperY = airPurifier.get(0);
        int lowerY = airPurifier.get(1);

        while (T-- > 0) {
            spreadDust(); // 먼지 확산
            cleanDust(upperY, lowerY); // 공기청정기 작동
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (air[i][j] > 0) {
                    answer += air[i][j];
                }
            }
        }

        System.out.println(answer);
    }
}
