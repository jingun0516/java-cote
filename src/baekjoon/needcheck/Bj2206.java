package baekjoon.needcheck;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bj2206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dx = new int[]{-1 ,1 ,0 ,0};
        int[] dy = new int[]{0, 0, 1, -1};

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] maps = new int[N][M];
        int[][][] visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                maps[i][j] = line.charAt(j) - '0'; // 문자를 숫자로 변환
            }
        }


        Queue<int[]> qu = new LinkedList<>();
        visited[0][0][0] = 1;

        qu.add(new int[]{0, 0, 0});

        while(!qu.isEmpty()) {
            int[] cur = qu.poll();
            int y = cur[0];
            int x = cur[1];
            int broken = cur[2];

            if(y == N - 1 && x == M - 1) {
                System.out.println(visited[y][x][broken]);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    // 벽이 아니고, 방문하지 않았을 경우
                    if(maps[ny][nx] == 0 && visited[ny][nx][broken] == 0) {
                        visited[ny][nx][broken] = visited[y][x][broken] + 1;
                        qu.add(new int[]{ny, nx, broken});
                    }

                    // 벽이고, 아직 부수지 않았을 경우
                    if(maps[ny][nx] == 1 && broken == 0 && visited[ny][nx][1] == 0) {
                        visited[ny][nx][1] = visited[y][x][broken] + 1;
                        qu.add(new int[]{ny, nx, 1});
                    }
                }
            }
        }

        System.out.println(-1);
        return;
    }
}
