package baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Bj17829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] maps = new int[N][N];
        for(int i = 0; i <N; i++) {
            for(int j = 0; j < N; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        while(N > 1) {
            int newSize = N / 2;

            int[][] newMaps = new int[newSize][newSize];

            for(int i = 0; i < N; i = i+2) {
                for(int j = 0; j < N; j = j+2) {
                    newMaps[i/2][j/2] = calculateSecond(i, j, maps);
                }
            }

            maps = newMaps;
            N = newSize;
        }

        System.out.println(maps[0][0]);
    }

    public static int calculateSecond(int y, int x, int[][] maps) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(maps[y][x]);
        pq.add(maps[y][x+1]);
        pq.add(maps[y+1][x]);
        pq.add(maps[y+1][x+1]);

        pq.poll();
        return pq.poll();
    }
}
