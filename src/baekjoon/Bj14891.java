package baekjoon;

import java.util.Scanner;

public class Bj14891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] wheels = new String[4];
        for (int i = 0; i < 4; i++) {
            wheels[i] = sc.nextLine();
        }

        int wheelNum = sc.nextInt();
        while (wheelNum-- > 0) {
            int index = sc.nextInt() - 1;
            int direction = sc.nextInt();

            // 각 톱니바퀴의 회전 방향 저장 (-1: 반시계, 1: 시계, 0: 회전 없음)
            int[] directions = new int[4];
            directions[index] = direction;

            // 왼쪽 확인
            for (int i = index - 1; i >= 0; i--) {
                if (wheels[i + 1].charAt(6) != wheels[i].charAt(2)) {
                    directions[i] = -directions[i + 1];  // 방향 반전
                } else {
                    break;
                }
            }

            // 오른쪽 확인
            for (int i = index + 1; i < 4; i++) {
                if (wheels[i - 1].charAt(2) != wheels[i].charAt(6)) {
                    directions[i] = -directions[i - 1];  // 방향 반전
                } else {
                    break;
                }
            }

            // 실제 회전 수행
            for (int i = 0; i < 4; i++) {
                if (directions[i] != 0) {
                    wheels[i] = shift(wheels[i], directions[i]);
                }
            }
        }

        // 점수 계산
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (wheels[i].charAt(0) == '1') {
                answer += (1 << i);  // 2^i 연산
            }
        }

        System.out.println(answer);
    }

    public static String shift(String str, int direction) {
        if (direction == 1) { // 시계 방향
            return str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
        } else { // 반시계 방향
            return str.substring(1) + str.charAt(0);
        }
    }
}
