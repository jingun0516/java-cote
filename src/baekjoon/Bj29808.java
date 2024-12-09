package baekjoon;

import java.util.*;

public class Bj29808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        if(s % 4763 != 0) {
            System.out.println(0);
            return;
        }

        s /= 4763;

        List<int[]> list = new ArrayList<>();

        for(int A = 0; A <= 200; A++) {
            for(int B = 0; B <= 200; B++) {
                if(s == A * 508 + B * 212 ||
                        s == A * 508 + B * 305 ||
                        s == A * 108 + B * 212 ||
                        s == A * 108 + B * 305) {
                    list.add(new int[]{A, B});
                }
            }
        }
        list.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // 0번 인덱스 기준 오름차순
            } else {
                return Integer.compare(a[1], b[1]); // 1번 인덱스 기준 오름차순
            }
        });

        System.out.println(list.size());
        for(int[] l : list) {
            System.out.println(l[0] + " " + l[1]);
        }
    }
}


/*
국어 점수가 영어 점수보다 높다면, 두 점수의 차에 인문관의 건물 번호
$508$을 곱해준다. 아니라면, 두 점수의 차에 국제관의 건물 번호
$108$을 곱해준다.
수학 점수가 탐구 점수보다 높다면, 두 점수의 차에 제1공학관의 건물 번호
$212$를 곱해준다. 아니라면, 두 점수의 차에 ITBT관의 건물 번호
$305$을 곱해준다.
위에서 계산한 두 값을 더한 뒤, 한양대학교의 우편번호
$04763 (=4763)$을 곱하면 학번이 나온다.
 */
