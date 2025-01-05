package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bj2578 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] bingo = new int[5][5];
        Map<Integer, int[]> maps = new HashMap<>();

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                int num = sc.nextInt();
                bingo[i][j] = num;
                maps.put(num, new int[]{i, j});
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                int num = sc.nextInt();
                if(maps.containsKey(num)){
                    int y = maps.get(num)[0];
                    int x = maps.get(num)[1];
                    bingo[y][x] = 0;
                }

                int cnt = 0;
                if(bingo[2][2] == 0) {
                    if(bingo[0][0] == 0 && bingo[1][1] == 0 &&
                            bingo[3][3] == 0 && bingo[4][4] == 0) {
                        cnt++;
                    }
                    if(bingo[4][0] == 0 && bingo[3][1] == 0 &&
                            bingo[1][3] == 0 && bingo[0][4] == 0) {
                        cnt++;
                    }
                }

                int cnt1 = 5;
                for(int k = 0; k < 5; k++){
                    for(int l = 0; l < 5; l++){
                        if(bingo[k][l] != 0) {
                            cnt1--;
                            break;
                        }
                    }
                }

                int cnt2 = 5;
                for(int k = 0; k < 5; k++){
                    for(int l = 0; l < 5; l++){
                        if(bingo[l][k] != 0) {
                            cnt2--;
                            break;
                        }
                    }
                }

                cnt += cnt1 + cnt2;

                if(cnt >= 3) {
                    System.out.println(i*5 + j+1);
                    return;
                }
            }
        }
    }
}
