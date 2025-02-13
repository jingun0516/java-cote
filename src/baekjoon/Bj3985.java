package baekjoon;

import java.util.Scanner;

public class Bj3985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int N = sc.nextInt();

        boolean[] cake = new boolean[L+1];
        int maxV = 0;
        int want = 0;
        int num = 0;
        int maxCnt = 0;
        for(int i = 1; i <= N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            if(end - start + 1 > maxV) {
                maxV = end - start + 1;
                want = i;
            }

            int cnt = 0;
            for(int j = start; j <= end; j++) {
                if(!cake[j]) {
                    cake[j] = true;
                    cnt++;
                }
            }
            if(cnt > maxCnt) {
                maxCnt = cnt;
                num = i;
            }
        }

        System.out.println(want);
        System.out.println(num);
    }
}
