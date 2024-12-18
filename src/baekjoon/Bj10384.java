package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bj10384 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            str = str.toUpperCase();

            Map<Character, Integer> map = new HashMap<>();
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) >= 'A' && str.charAt(j) <= 'Z') {
                    map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
                }
            }

            System.out.print("Case " + (i+1) + ": ");
            if(map.size() < 26) {
                System.out.println("Not a pangram");
            } else {
                int limit = 3;
                for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                    int num = entry.getValue();
                    if(num < limit) {
                        limit = num;
                    }
                }

                switch(limit) {
                    case 3:
                        System.out.println("Triple pangram!!!");
                        break;

                    case 2:
                        System.out.println("Double pangram!!");
                        break;

                    case 1:
                        System.out.println("Pangram!");
                }
            }
        }
    }
}
