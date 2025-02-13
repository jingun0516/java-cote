package baekjoon;

import java.util.Scanner;

public class Bj1356 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n < 10) {
            System.out.println("NO");
            return;
        }

        String str = String.valueOf(n);

        int start = 0;
        int end = str.length() - 1;

        for(int i = 0; i < str.length(); i++) {
            String num1 = str.substring(0, i);
            String num2 = str.substring(i);

            int a = 1;
            int b = 1;

            for(int j = 0; j < num1.length(); j++) {
                a *= num1.charAt(j) - '0';
            }
            for(int j = 0; j < num2.length(); j++) {
                b *= num2.charAt(j) - '0';
            }

            if(a == b) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
