package programmers;

import java.util.Scanner;

public class Pm340199 {
    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int maxWallet = Math.max(wallet[0], wallet[1]);
        int minWallet = Math.min(wallet[0], wallet[1]);

        while(maxWallet < Math.max(bill[0], bill[1]) || minWallet < Math.min(bill[0], bill[1])) {
            if(bill[0] >= bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] wallet = {30, 15};
        int[] bill = {26, 17};


        System.out.println(solution(wallet, bill));
    }
}
