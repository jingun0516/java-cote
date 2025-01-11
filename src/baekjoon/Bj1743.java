package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bj1743 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        int[][] maps = new int[N+1][M+1];
        boolean[][] visited = new boolean[N+1][M+1];

        for(int i = 0; i < K; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();

            maps[y][x] = 1;
        }

        int answer = 0;
        Queue<int[]> qu = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(maps[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    int cnt = 0;
                    qu.add(new int[]{i, j});

                    while(!qu.isEmpty()) {
                        int[] cur = qu.poll();
                        int y = cur[0];
                        int x = cur[1];
                        cnt++;

                        answer = Math.max(answer, cnt);

                        for(int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx >= 0 && ny >= 0 && ny <= N && nx <= M && !visited[ny][nx] && maps[ny][nx] == 1) {
                                visited[ny][nx] = true;
                                qu.add(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
