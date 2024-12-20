package baekjoon;

import java.util.Scanner;

public class Bj2851 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] mushrooms = new int[10];

        for(int i = 0; i < mushrooms.length; i++) {
            mushrooms[i] = sc.nextInt();
        }

        int score = 0;

        for(int i = 0; i < mushrooms.length; i++) {
            int nextScore = score + mushrooms[i];
            if(Math.abs(100 - nextScore) <= Math.abs(100 - score)) {
                score = nextScore;
            } else {
                break;
            }
        }

        System.out.println(score);
    }
}
