package baekjoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bj2468 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};

        int N = sc.nextInt();
        int maxHeight = 0;

        int[][] maps = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                maps[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, maps[i][j]);
            }
        }

        int answer = 1;
        for(int h = 1; h <= maxHeight; h++) {
            boolean[][] visited = new boolean[N][N];

            for(int y = 0; y < N; y++) {
                for(int x = 0; x < N; x++) {
                    if(maps[y][x] <= h) {
                        visited[y][x] = true;
                    }
                }
            }

            Queue<int[]> qu = new LinkedList<>();

            int count = 0;

            for(int y = 0; y < N; y++) {
                for(int x = 0; x < N; x++) {
                    if(!visited[y][x]) {
                        visited[y][x] = true;
                        qu.add(new int[]{y, x});
                        count++;
                    }

                    while(!qu.isEmpty()) {
                        int[] cur = qu.poll();
                        int yy = cur[0];
                        int xx = cur[1];

                        for(int i = 0; i < 4; i++) {
                            int ny = yy + dy[i];
                            int nx = xx + dx[i];

                            if(ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
                                visited[ny][nx] = true;
                                qu.add(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }

            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}
