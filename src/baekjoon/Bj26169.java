package baekjoon;

import java.util.Scanner;

public class Bj26169 {    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int answer = 0;

    public static void dfs(int x, int y, int[][] maps, int cnt, int dist) {
        if(cnt >= 2) {
            answer = 1;
            return;
        }

        if(dist >= 3) {
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(isCan(nx, ny) && maps[ny][nx] != -1) {
                int newCnt = 0;
                if(maps[ny][nx] == 0) {
                    newCnt = cnt;
                } else {
                    newCnt = cnt + 1;
                }
                int origin = maps[ny][nx];
                maps[ny][nx] = -1;
                dfs(nx, ny, maps, newCnt, dist + 1);
                maps[ny][nx] = origin;
            }

        }

    }

    public static boolean isCan(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] maps = new int[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                maps[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt();
        int c = sc.nextInt();

        maps[r][c] = -1;
        dfs(c, r, maps, 0, 0);

        System.out.println(answer);
    }
}
