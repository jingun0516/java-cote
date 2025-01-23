package baekjoon;

import java.util.*;

public class Bj30457 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        Map<Integer, Integer> maps = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            maps.put(arr[i], maps.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();

            if (count > 0) {
                A.add(key); // A에 추가
                count--;
            }

            if (count > 0) {
                B.add(key); // B에 추가
            }
        }
        System.out.println(A.size() + B.size());
    }
}
