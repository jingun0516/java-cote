package baekjoon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bj1253 {
    static long answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<Long> longSet = new HashSet<>();

        long[] array = new long[N];
        for(int i = 0; i < N; i++) {
            array[i]=sc.nextLong();
        }
        Arrays.sort(array);

        if(N <= 2) {
            System.out.println(0);
            return;
        }

        for(int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;

            if(longSet.contains(array[i])) {
                answer++;
                continue;
            }

            while(left < right) {
                long num = array[left] + array[right];

                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i) {
                    right--;
                    continue;
                }

                if(array[i] > num) {
                    left++;
                } else if(array[i] < num) {
                    right--;
                } else {
                    answer++;
                    longSet.add(array[i]);
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
