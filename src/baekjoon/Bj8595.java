package baekjoon;

import java.util.*;


public class Bj8595 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String temp = sc.next();

        long answer = 0; // 결과를 저장할 변수 (Long 타입 사용)
        StringBuilder num = new StringBuilder(); // 숫자를 임시로 저장

        for (int i = 0; i < n; i++) {
            char ch = temp.charAt(i);

            if (Character.isDigit(ch)) {
                num.append(ch); // 숫자인 경우 추가
                // 숫자가 6자리를 초과할 경우 잘라서 처리
                if (num.length() > 6) {
                    num.setLength(6);
                }
            } else {
                if (num.length() > 0) { // 숫자 추출 후 합산
                    answer += Long.parseLong(num.toString());
                    num.setLength(0); // 초기화
                }
            }
        }

        // 마지막 숫자 처리
        if (num.length() > 0) {
            answer += Long.parseLong(num.toString());
        }

        System.out.println(answer);
    }
}
