package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Bj2075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] maps = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                maps[i][j] = sc.nextInt();
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int x = 0; x < N; x++){
            pq.add(new Node(maps[N - 1][x], N - 1, x));
        }

        int cnt = 0;
        while(!pq.isEmpty()){
            cnt++;
            Node node = pq.poll();
            int value = node.getValue();
            int y = node.getY();
            int x = node.getX();

            if(cnt == N) {
                System.out.println(value);
                return;
            }

            if(y >= 1) {
                pq.add(new Node(maps[y-1][x], y - 1, x));
            }
        }

    }

    public static class Node implements Comparable<Node>{
        int value;
        int y;
        int x;

        public Node(int value, int y, int x) {
            this.value = value;
            this.y = y;
            this.x = x;
        }

        public int getValue() {
            return value;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        @Override
        public int compareTo(Node o) {
            return o.value - this.value;
        }
    }
}
