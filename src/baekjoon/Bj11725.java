package baekjoon;

import java.util.*;

public class Bj11725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<Integer, List<Integer>> maps = new HashMap<>();
        Map<Integer, Integer> family = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            maps.put(i, new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            maps.get(a).add(b);
            maps.get(b).add(a);
        }

        Queue<int[]> qu = new LinkedList<>();

        for(Integer child : maps.get(1)) {
            qu.add(new int[]{child, 1});
        }

        while(!qu.isEmpty()) {
            int[] cur = qu.poll();
            int child = cur[0];
            int parent = cur[1];

            family.put(child, parent);

            for(Integer connect : maps.get(child)) {
                if(connect != parent) {
                    qu.add(new int[]{connect, child});
                }
            }
        }

        for(int i = 2; i <= N; i++) {
            System.out.println(family.get(i));
        }
    }
}
