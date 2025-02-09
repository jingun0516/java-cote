package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bj1380 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 1;
        while(true) {
            int N = sc.nextInt();
            if(N == 0) {
                break;
            }
            sc.nextLine();

            String[] students = new String[N];

            for(int i = 0; i < N; i++) {
                students[i] = sc.nextLine();
            }

            Map<Integer, Integer> maps = new HashMap<>();
            for(int i = 0; i < 2 * N - 1; i++) {
                int num = sc.nextInt();
                String alphabet = sc.next();

                if(maps.containsKey(num)) {
                    maps.put(num, maps.get(num) + 1);
                } else {
                    maps.put(num, 1);
                }
            }

            for(Map.Entry<Integer, Integer> m : maps.entrySet()) {
                if(m.getValue() == 1) {
                    System.out.println(cnt + " "+ students[m.getKey() - 1]);
                }
            }
            cnt++;
        }
    }
}
