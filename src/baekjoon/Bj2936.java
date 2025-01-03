package baekjoon;

import java.util.Scanner;

public class Bj2936 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        double grid = 250.0 * 250.0 / 2.0;  // 삼각형 넓이
        double newGrid = grid / 2.0;        // 삼각형 넓이의 반

        // y = -x + 250;
        // x = 250 - y;
        double answerX = 0.0;
        double answerY = 0.0;
        if (x == 0) {
            if (y <= 125) {
                answerX = newGrid / (250 - y) * 2.0;
                answerY = -answerX + 250;
            } else {
                answerY = 0;
                answerX = newGrid * 2.0 / y;
            }
        } else if (y == 0) {
            if (x <= 125) {
                answerY = newGrid / (250 - x) * 2.0;
                answerX = 250 - answerY;
            } else {
                answerX = 0;
                answerY = newGrid * 2.0 / x;
            }
        } else if (x > y) {
            answerX = 0;
            answerY = 250 - (newGrid * 2.0) / x;
        } else if (y > x) {
            answerY = 0;
            answerX = 250 - (newGrid * 2.0) / y;
        }

        System.out.printf("%.2f %.2f%n", answerX, answerY);
    }
}
