package baekjoon;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Bj13414 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int L = sc.nextInt();

        Set<String> set = new LinkedHashSet<>();
        for(int i = 0; i < L; i++) {
            String num = sc.next();
            if(set.contains(num)) {
                set.remove(num);
            }

            set.add(num);
        }

        int cnt = 0;
        for(String num : set) {
            System.out.println(num);
            cnt++;
            if(cnt >= K) {
                break;
            }
        }
    }
}
