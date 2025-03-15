package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bj5671 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int answer = 0;
            for (int i = n; i <= m; i++) {
                String str = Integer.toString(i);

                Set<Character> list = new HashSet<>();
                boolean check = true;

                for (int j = 0; j < str.length(); j++) {
                    if (!list.contains(str.charAt(j))) {
                        list.add(str.charAt(j));
                    } else {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    answer++;
                }
            }

            System.out.println(answer);
        }

    }
}
