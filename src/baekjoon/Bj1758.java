package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bj1758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> tips = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            tips.add(sc.nextInt());
        }

        Collections.sort(tips, Collections.reverseOrder());

        long answer = 0;
        for(int i = 0; i < tips.size(); i++) {
            int tip = tips.get(i) - i;
            if(tip > 0) {
                answer += tip;
            }
        }

        System.out.println(answer);
    }
}
