package baekjoon;

import java.util.Scanner;

public class Bj14709 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if(N != 3) {
            System.out.println("Woof-meow-tweet-squeek");
            return;
        }

        int[][] arr = new int[6][6];

        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == 2 || a == 5 || b == 2 || b == 5) {
                System.out.println("Woof-meow-tweet-squeek");
                return;
            }

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        if(arr[1][3] == 1 && arr[1][4] == 1 && arr[3][4] == 1) {
            System.out.println("Wa-pa-pa-pa-pa-pa-pow!");
        } else {
            System.out.println("Woof-meow-tweet-squeek");
        }

    }
}
