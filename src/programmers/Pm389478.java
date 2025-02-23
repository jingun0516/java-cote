package programmers;

public class Pm389478 {
    public static int solution(int n, int w, int num) {
        int answer = 0;

        int[][] maps = new int[n/w+1][w];

        int cnt = 1;
        int y = 0;
        int x = 0;

        boolean check = false;
        for(int i = 0; i < n/w+1; i++) {
            if(check) {
                break;
            }
            if(i % 2 == 0) {
                for(int j = 0; j < w; j++) {
                    if(cnt == num) {
                        y = i;
                        x = j;
                    }
                    maps[i][j] = cnt++;
                    if(cnt > n) {
                        check = true;
                        break;
                    }
                }
            } else {
                for(int j = w - 1; j >= 0; j--) {
                    if(cnt == num) {
                        y = i;
                        x = j;
                    }
                    maps[i][j] = cnt++;
                    if(cnt > n) {
                        check = true;
                        break;
                    }
                }
            }
        }

        for(int i = n/w; i >= y; i--) {
            if(maps[i][x] != 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 13;
        int w = 3;
        int num = 6;
        System.out.println(solution(n, w, num));
    }
}
