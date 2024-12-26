package baekjoon;

import java.util.Scanner;

public class Bj1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String toFind = sc.nextLine();

        str = str.replaceAll(toFind, "A");

        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A') {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
