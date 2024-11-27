package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bj11637 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            int n = sc.nextInt();
            List<Integer> cands = new ArrayList<>();

            int maxV = 0;
            int sum = 0;
            int num = 0;
            boolean isSame = false;

            for(int i = 0; i < n; i++) {
                cands.add(sc.nextInt());
                if(maxV == cands.get(i)) {
                    isSame = true;
                } else if(cands.get(i) > maxV) {
                    maxV = cands.get(i);
                    num = i + 1;
                    isSame = false;
                }
                sum += cands.get(i);
            }

            if(isSame) {
                System.out.println("no winner");
            } else {
                if(maxV > sum / 2) {
                    System.out.println("majority winner " + num);
                } else {
                    System.out.println("minority winner " + num);
                }
            }
        }
    }
}
