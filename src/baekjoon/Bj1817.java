package baekjoon;

import java.util.Scanner;

public class Bj1817 {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] books = new int[N];

        for(int i = 0; i < N; i++) {
            books[i] = sc.nextInt();
        }

        if(N == 0) {
            System.out.println(0);
            return;
        }
        answer = 1;
        int temp = M - books[0];
        for(int i = 1; i < N; i++) {
            if(books[i] <= temp) {
                temp -= books[i];
            } else {
                answer++;
                temp = M - books[i];
            }
        }

        System.out.println(answer);
    }
    // https://www.acmicpc.net/problem/1817
}
