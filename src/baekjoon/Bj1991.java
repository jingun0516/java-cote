package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bj1991 {
    public static void preOrder(String root, Map<String, String[]> maps) {
        String left = maps.get(root)[0];
        String right = maps.get(root)[1];

        System.out.print(root);

        if(!left.equals(".")) {
            preOrder(left, maps);
        }

        if(!right.equals(".")) {
            preOrder(right, maps);
        }
    }

    public static void inOrder(String root, Map<String, String[]> maps) {
        String left = maps.get(root)[0];
        String right = maps.get(root)[1];

        if(!left.equals(".")) {
            inOrder(left, maps);
        }

        System.out.print(root);

        if(!right.equals(".")) {
            inOrder(right, maps);
        }
    }

    public static void postOrder(String root, Map<String, String[]> maps) {
        String left = maps.get(root)[0];
        String right = maps.get(root)[1];

        if(!left.equals(".")) {
            postOrder(left, maps);
        }

        if(!right.equals(".")) {
            postOrder(right, maps);
        }

        System.out.print(root);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<String, String[]> maps = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String a = sc.next();
            String b = sc.next();
            String c = sc.next();

            maps.put(a, new String[] {b, c});
        }

        // 전위 순회
        preOrder("A", maps);
        System.out.println();

        // 중위 순회
        inOrder("A", maps);
        System.out.println();

        // 후위 순회
        postOrder("A", maps);
        System.out.println();
    }
}
