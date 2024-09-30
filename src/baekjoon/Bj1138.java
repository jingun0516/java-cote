package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bj1138 {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> people = new ArrayList<>();
        for(int i = 0; i < N; i++){
            people.add(sc.nextInt());
        }

        int[] ansArr = new int[N];

        for(int i = 0; i < N; i++) {
            int cnt = people.get(i);
            for(int j = 0; j < N; j++) {
                if(ansArr[j] == 0) {        // i 보다 큰 값이다
                    if(cnt == 0) {
                        ansArr[j] = i+1;
                        break;
                    }
                    cnt--;
                } else {
                    if(ansArr[j] > i+1) {
                        cnt--;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.print(ansArr[i] + " ");
        }

    }
}
