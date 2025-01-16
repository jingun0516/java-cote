package baekjoon;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Bj1822 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        Set<Integer> aSet = new TreeSet<>();

        for(int i = 0; i < A; i++){
            aSet.add(sc.nextInt());
        }

        for(int i = 0; i < B; i++){
            aSet.remove(sc.nextInt());
        }

        System.out.println(aSet.size());
        for(Integer i : aSet){
            System.out.print(i + " ");
        }
    }
}
