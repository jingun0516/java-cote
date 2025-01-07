package baekjoon.needcheck;

import java.util.*;

public class Bj1967 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Map<Integer, List<int[]>> maps = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            maps.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            int time = sc.nextInt();

            maps.get(parent).add(new int[]{child, time});
            maps.get(child).add(new int[]{parent, time});
        }

        // Step 1: 임의의 노드(1번)에서 가장 먼 노드 찾기
        // 리프 노드 중 가장 멀리 있는 노드 (루트노드에서)
        int[] farthestFromStart = findFarthestNode(1, N, maps);

        // Step 2: 가장 먼 노드에서 다시 가장 먼 노드 찾기
        int[] result = findFarthestNode(farthestFromStart[0], N, maps);

        // 트리의 지름 출력
        System.out.println(result[1]);
    }

    static int[] findFarthestNode(int start, int N, Map<Integer, List<int[]>> maps) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.add(new int[]{start, 0}); // {현재 노드, 거리}
        visited[start] = true;

        int farthestNode = start;
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int distance = cur[1];

            if (distance > maxDistance) {
                maxDistance = distance;
                farthestNode = node;
            }

            for (int[] edge : maps.get(node)) {
                int nextNode = edge[0];
                int time = edge[1];

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(new int[]{nextNode, distance + time});
                }
            }
        }

        return new int[]{farthestNode, maxDistance};
    }
}
