package baekjoon;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Bj5587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Set<Integer> aSet = new TreeSet<>();
        Set<Integer> bSet = new TreeSet<>();

        for(int i = 1; i <= n * 2; i++) {
            bSet.add(i);
        }

        for(int i = 0; i < n; i++) {
            aSet.add(sc.nextInt());
        }
        bSet.removeAll(aSet);

        int card = 0;
        boolean isATurn = true;
        while(true) {
            boolean isDone = false;

            if(isATurn) {
                for(Integer a : aSet) {
                    if(a > card) {
                        aSet.remove(a);
                        card = a;
                        isDone = true;
                        break;
                    }
                }
                if(!isDone) {
                    card = 0;
                }
                isATurn = false;
            } else {
                for(Integer b : bSet) {
                    if(b > card) {
                        bSet.remove(b);
                        card = b;
                        isDone = true;
                        break;
                    }
                }
                if(!isDone) {
                    card = 0;
                }
                isATurn = true;
            }

            if(aSet.isEmpty() || bSet.isEmpty()) {
                System.out.println(bSet.size());
                System.out.println(aSet.size());
                return;
            }
        }
    }
}
