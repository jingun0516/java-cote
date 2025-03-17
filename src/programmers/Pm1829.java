package programmers;

public class Pm1829 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];

        boolean[][] visited = new boolean[m][n];

        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                if(!visited[y][x] && picture[y][x] != 0) {
                    visited[y][x] = true;
                    maxSizeOfOneArea = Math.max(dfs(y, x, picture, visited, 1), maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.println(answer[0]);
        System.out.println(answer[1]);

        return answer;
    }

    public static int dfs(int y, int x, int[][] picture, boolean[][] visited, int cnt) {
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(!check(ny, nx, picture) || picture[ny][nx] == 0 || visited[ny][nx]) {
                continue;
            }

            if(picture[y][x] == picture[ny][nx]) {
                visited[ny][nx] = true;
                cnt = dfs(ny, nx, picture, visited, cnt+1);
            }
        }

        return cnt;
    }

    public static boolean check(int y, int x, int[][] picture) {
        return y >= 0 && y < picture.length && x >= 0 && x < picture[0].length;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

        solution(m, n, picture);
    }
}
