package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Bj23253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        String answer = "Yes";

        for(int i = 0; i < M; i++) {
            int k = sc.nextInt();
            int bef = 0;
            for(int j = 0; j < k; j++) {
                int num = sc.nextInt();
                if(bef != 0 && num > bef) {
                    answer = "No";
                    System.out.println(answer);
                    return;
                }
                bef = num;
            }
        }

        System.out.println(answer);
    }
}


/*
찬우는 스택을 배운 뒤 자료구조 과목과 사랑에 빠지고 말았다.

자료구조 과목만을 바라보기로 다짐한 찬우는 나머지 과목의 교과서
$N$권을 방 구석에
$M$개의 더미로 아무렇게나 쌓아 두었다. 하지만 중간고사가 다가오자 더 이상 자료구조만 공부할 수는 없었고,
결국 찬우는 팽개쳤던 나머지 과목의 교과서를 정리하고 번호순으로 나열하려 한다.

 
$N$권의 교과서는 각각
$1$부터
$N$까지의 번호가 매겨져 있다. 찬우는 각 더미의 맨 위에 있는 교과서만 꺼낼 수 있으며,
반드시 교과서를 꺼낸 순서대로 나열해야 하기 때문에 번호순으로 나열하기 위해서는
$1$번,
$2$번, …
$N - 1$번,
$N$번 교과서 순으로 꺼내야 한다. 교과서를 올바르게 나열할 수 없다면 중간고사 공부를 때려치겠다는
찬우를 위해 번호순으로 나열할 수 있는지 여부를 알려주는 프로그램을 작성해 주자.

 */