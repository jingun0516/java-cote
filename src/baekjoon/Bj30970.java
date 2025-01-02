package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bj30970 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int[] arr = new int[2];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            list.add(arr);
        }

        // 정렬
        list.sort((a, b) -> {
            if (b[0] != a[0]) { // arr[0]이 큰 순서대로
                return Integer.compare(b[0], a[0]);
            } else { // arr[1]이 작은 순서대로
                return Integer.compare(a[1], b[1]);
            }
        });

        System.out.println(list.get(0)[0] + " " + list.get(0)[1] + " " + list.get(1)[0] + " " + list.get(1)[1]);

        // 정렬
        list.sort((a, b) -> {
            if (b[1] != a[1]) { // arr[1]이 작은 순서대로
                return Integer.compare(a[1], b[1]);
            } else { // arr[0]이 큰 순서대로
                return Integer.compare(b[0], a[0]);
            }
        });
        System.out.println(list.get(0)[0] + " " + list.get(0)[1] + " " + list.get(1)[0] + " " + list.get(1)[1]);
    }
}
