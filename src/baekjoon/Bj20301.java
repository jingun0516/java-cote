package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bj20301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = sc.nextInt();

        int cnt = 0;
        boolean[] isOut = new boolean[N + 1];

        int num = 0;

        List<Integer> list = new ArrayList<>();

        boolean isReverse = false;
        while(list.size() < N) {
            if(!isReverse) {
                num++;
                if(num > N) {
                    num = 1;
                }
            } else{
                num--;
                if(num < 1) {
                    num = N;
                }
            }

            if(!isOut[num]) {
                cnt++;
                if(cnt % K == 0) {
                    list.add(num);
                    isOut[num] = true;
                    cnt = 0;

                    if(list.size() % M == 0) {
                        isReverse = !isReverse;
                    }
                }
            }
        }
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
