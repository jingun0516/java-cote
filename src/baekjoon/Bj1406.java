package baekjoon;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Bj1406 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Character> letters = new LinkedList<>();
        String input = sc.nextLine();

        for(char c : input.toCharArray()) {
            letters.add(c);
        }

        int N = sc.nextInt();

        ListIterator<Character> iter = letters.listIterator(letters.size()); // 커서를 문자열 끝에 둠

        for (int i = 0; i < N; i++) {
            String option = sc.next();

            switch (option) {
                case "L":
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;

                case "D":
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;

                case "B":
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;

                case "P":
                    String letter = sc.next();
                    iter.add(letter.charAt(0));
                    break;
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character c : letters) {
            result.append(c);
        }
        System.out.println(result);
    }
}
