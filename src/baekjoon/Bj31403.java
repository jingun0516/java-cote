package baekjoon;

import java.util.Scanner;

public class Bj31403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int strResult = Integer.parseInt(Integer.toString(A)+Integer.toString(B))-C;
        System.out.println(A+B-C);
        System.out.println(strResult);
    }
}
