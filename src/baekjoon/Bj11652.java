package baekjoon;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Bj11652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<Long, Integer> maps = new TreeMap<>();

        for(int i = 1; i <= n; i++) {
            long num = sc.nextLong();

            maps.put(num, maps.getOrDefault(num, 0) + 1);
        }

        Long answer = Long.MIN_VALUE;
        Integer maxV = 0;
        for(Map.Entry<Long, Integer> entry : maps.entrySet()) {
            if(entry.getValue() > maxV) {
                answer = entry.getKey();
                maxV = entry.getValue();
            }
        }

        System.out.println(answer);
    }
}
