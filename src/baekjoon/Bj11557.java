package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bj11557 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {

            int N = sc.nextInt();
            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < N; i++) {
                String school = sc.next();
                int L = sc.nextInt();

                if(map.containsKey(school)) {
                    map.put(school, map.get(school) + L);
                } else {
                    map.put(school, L);
                }
            }

            String answer = "";
            int maxV = 0;

            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue() > maxV) {
                    answer = entry.getKey();
                    maxV = entry.getValue();
                }
            }

            System.out.println(answer);
        }


    }
}
