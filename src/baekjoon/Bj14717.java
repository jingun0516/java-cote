package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bj14717 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> cards = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            cards.add(i);
            cards.add(i);
        }

        int a1 = sc.nextInt();
        int a2 = sc.nextInt();

        cards.remove(Integer.valueOf(a1));
        cards.remove(Integer.valueOf(a2));

        int score1 = calculateScore(a1, a2);
        int score2 = 0;

        int win = 0;
        int whole = 0;

        for(int i = 0; i < cards.size(); i++) {
            for(int j = 0; j < cards.size(); j++) {
                if(i == j) {
                    continue;
                }
                whole++;
                score2 = calculateScore(cards.get(i), cards.get(j));
                if(score1 > score2) {
                    win++;
                }
            }
        }

        double answer = (double) win / whole;

        System.out.printf("%.3f", answer);

    }

    public static int calculateScore(int card1, int card2) {
        if(card1 == card2) {
            return 10 + card1;
        } else {
            return (card1 + card2) % 10;
        }
    }
}
