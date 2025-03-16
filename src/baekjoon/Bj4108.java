package baekjoon;

import java.util.Scanner;

public class Bj4108 {

    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dy = {-1, 1, 0, 0, 1, -1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int R = sc.nextInt();
            int C = sc.nextInt();

            if(R == 0 || C == 0) {
                break;
            }

            String[] mines = new String[R];

            for(int i = 0; i < R; i++) {
                mines[i] = sc.next();
            }

            String[] ansMines = new String[R];

            for(int i = 0; i < R; i++) {
                StringBuilder str = new StringBuilder();
                for(int j = 0; j < C; j++) {
                    if(mines[i].charAt(j) == '*') {
                        str.append('*');
                    } else {
                        int mine = calMines(i, j, mines);
                        str.append(mine);
                    }
                }
                ansMines[i] = str.toString();
            }

            for(int i = 0; i < R; i++) {
                System.out.println(ansMines[i]);
            }
        }



    }

    static int calMines(int y, int x, String[] mines) {
        int cnt = 0;

        for(int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= mines.length || nx >= mines[0].length()) {
                continue;
            }

            if(mines[ny].charAt(nx) == '*') {
                cnt++;
            }
        }
        return cnt;
    }
}
