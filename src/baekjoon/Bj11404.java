package baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bj11404 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 노드 개수
        int M = sc.nextInt(); // 간선 개수

        int[][] maps = new int[N + 1][N + 1];

        // 그래프 초기화
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();

            if (maps[start][end] == 0) {
                maps[start][end] = cost;
            } else {
                maps[start][end] = Math.min(maps[start][end], cost);
            }
        }

        // 각 노드를 시작점으로 BFS 실행
        for (int i = 1; i <= N; i++) {
            int[] answer = new int[N + 1];
            Arrays.fill(answer, Integer.MAX_VALUE);
            answer[i] = 0; // 시작점에서 시작점으로 가는 비용은 0

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{i, 0}); // 시작점 큐에 추가

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int currentNode = curr[0];
                int currentCost = curr[1];

                for (int nextNode = 1; nextNode <= N; nextNode++) {
                    if (maps[currentNode][nextNode] != 0) { // 연결된 노드가 있는 경우
                        int newCost = currentCost + maps[currentNode][nextNode];
                        if (newCost < answer[nextNode]) { // 더 적은 비용으로 갱신 가능
                            answer[nextNode] = newCost;
                            queue.add(new int[]{nextNode, newCost});
                        }
                    }
                }
            }

            // 결과 출력
            for (int j = 1; j <= N; j++) {
                if (answer[j] == Integer.MAX_VALUE) {
                    System.out.print("0 "); // 경로가 없는 경우 0 출력
                } else {
                    System.out.print(answer[j] + " ");
                }
            }
            System.out.println();
        }
    }
}
