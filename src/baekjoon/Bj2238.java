package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Bj2238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int U = sc.nextInt();
        int N = sc.nextInt();

        Map<Integer, Integer> prices = new TreeMap<>();
        Map<Integer, String> person = new HashMap<>();

        for(int i = 0; i < N; i++){
            String S = sc.next();
            int P = sc.nextInt();

            prices.put(P, prices.getOrDefault(P, 0) + 1);
            if(!person.containsKey(P)){
                person.put(P, S);
            }
        }

        int minPrice = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;

        for(Integer key : prices.keySet()){
            int value = prices.get(key);

            if(value < minValue) {
                minPrice = key;
                minValue = value;
            }
        }
        System.out.println(person.get(minPrice) + " " + minPrice);
    }
}
