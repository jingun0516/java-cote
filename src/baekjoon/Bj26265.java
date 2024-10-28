package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Bj26265 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        String[][] mento = new String[N][2];
        for(int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            mento[i][0] = input[0];
            mento[i][1] = input[1];
        }
        mento = Arrays.stream(mento)
                .sorted((a, b) -> {
                    int result = a[0].compareTo(b[0]);
                    return result != 0 ? result : b[1].compareTo(a[1]);
                })
                .toArray(String[][]::new);

        for(int i = 0; i < N; i++) {
            System.out.print(mento[i][0] + " " + mento[i][1] + "\n");
        }

    }
}
