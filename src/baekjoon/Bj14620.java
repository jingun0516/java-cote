package baekjoon;

import java.util.Scanner;

public class Bj14620 {
    public static int answer = 3001;

    public static boolean canPlant(boolean[][] check, int x, int y) {
        // 다 false면 true 반환
        if(!check[y][x] && !check[y-1][x] && !check[y+1][x] && !check[y][x-1] && !check[y][x+1]) {
            return true;
        }

        return false;
    }

    public static void plant(int x, int y, boolean[][] check) {
        check[y][x] = true;
        check[y-1][x] = true;
        check[y+1][x] = true;
        check[y][x-1] = true;
        check[y][x+1] = true;
    }

    public static void unplant(int x, int y, boolean[][] check) {
        check[y][x] = false;
        check[y-1][x] = false;
        check[y+1][x] = false;
        check[y][x-1] = false;
        check[y][x+1] = false;
    }
    public static void dfs(int x, int y, int cnt, int score, int[][] maps, boolean[][] check) {
        score += maps[y][x] + maps[y - 1][x] + maps[y + 1][x] + maps[y][x - 1] + maps[y][x + 1];

        if(cnt == 3) {
            answer = Math.min(answer, score);
            return;
        }

        for(int i = y; i < check.length - 1; i++) {
            for(int j = 1; j < check.length - 1; j++) {
                if(canPlant(check, j, i)) {
                    plant(j, i, check);
                    dfs(j, i, cnt + 1, score, maps, check);
                    unplant(j, i, check);

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] maps = new int[N][N];
        boolean[][] check = new boolean[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                maps[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i < N-1; i++){
            for(int j = 1; j < N-1; j++){
                plant(j, i, check);
                dfs(j, i, 1, 0, maps, check);
                unplant(j, i, check);
            }
        }

        System.out.println(answer);

    }
}
