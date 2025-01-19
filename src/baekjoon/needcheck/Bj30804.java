package baekjoon.needcheck;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bj30804 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] fruits = new int[N];

        for (int i = 0; i < N; i++) {
            fruits[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int answer = 0;

        for(int right = 0; right < N; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                int newLeftFruit = map.get(fruits[left]) - 1;
                if(newLeftFruit <= 0) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], newLeftFruit);
                }
                left++;
            }

            answer = Math.max(answer, right - left + 1);        // + 1인 이유: 배열의 길이를 구하기 위해
        }

        System.out.println(answer);
    }
}
