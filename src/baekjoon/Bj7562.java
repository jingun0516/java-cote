package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bj7562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            boolean[][] visited = new boolean[N][N];

            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int destX = sc.nextInt();
            int destY = sc.nextInt();

            visited[startX][startY] = true;

            Queue<int[]> qu = new LinkedList<>();

            qu.add(new int[]{startX, startY, 0});

            while(!qu.isEmpty()) {
                int[] cur = qu.poll();
                int x = cur[0];
                int y = cur[1];
                int cnt = cur[2];

                if(x == destX && y == destY) {
                    System.out.println(cnt);
                    break;
                }

                for(int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        qu.add(new int[]{nx, ny, cnt+1});
                    }
                }
            }
        }
    }
}
