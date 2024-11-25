package baekjoon;

import java.util.Scanner;

public class Bj4963 {
    static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dy = {1, -1, -1, 0, 1, -1, 0, 1};

    public static void dfs(int[][] maps, boolean[][] visited, int x, int y) {
        int w = maps[0].length;
        int h = maps.length;

        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < w && ny >= 0 && ny < h && !visited[ny][nx] && maps[ny][nx] == 1) {
                visited[ny][nx] = true;
                dfs(maps, visited, nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int w = sc.nextInt();
            int h = sc.nextInt();

            if(w == 0 && h == 0) break;

            int[][] maps = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    maps[i][j] = sc.nextInt();
                }
            }

            int cnt = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(!visited[i][j] && maps[i][j] == 1) {
                        dfs(maps, visited, j, i);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}
