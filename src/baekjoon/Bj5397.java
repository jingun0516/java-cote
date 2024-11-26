package baekjoon;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Bj5397 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < T; i++) {
            char c;

            String sentence = sc.nextLine();
            List<Character> letters = new LinkedList<>();
            ListIterator<Character> iter = letters.listIterator(0);

            for(int j = 0; j < sentence.length(); j++) {
                c = sentence.charAt(j);

                switch (c) {
                    case '<':
                        if(iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;

                    case '>':
                        if(iter.hasNext()) {
                            iter.next();
                        }
                        break;

                    case '-':
                        if(iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;

                    default:
                        iter.add(c);
                }
            }

            StringBuilder result = new StringBuilder();
            for (Character letter : letters) {
                result.append(letter);
            }
            System.out.println(result);
        }
    }
}
