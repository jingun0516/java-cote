package programmers;

import java.util.HashMap;
import java.util.Map;

public class Pm340211 {
    public static int solution(int[][] points, int[][] routes) {
        int answer = 0;

        int routeLen = routes[0].length;
        Map<Integer, int[]> robotPositions = new HashMap<>();
        int[] robotsGoing = new int[routes.length];

        // 로봇 초기 위치 설정
        for (int i = 0; i < routes.length; i++) {
            robotPositions.put(i, points[routes[i][0] - 1]);
        }

        while (!robotPositions.isEmpty()) {
            // 충돌 확인용 좌표 카운트 맵
            Map<String, Integer> positionCount = new HashMap<>();

            // 로봇 이동 처리
            for (int i = 0; i < robotsGoing.length; i++) {
                if (!robotPositions.containsKey(i)) continue; // 이미 완료된 로봇

                int destIndex = robotsGoing[i];
                if (destIndex >= routeLen) {
                    robotPositions.remove(i); // 경로 종료된 로봇 제거
                    continue;
                }

                int[] current = robotPositions.get(i);
                int[] destination = points[routes[i][destIndex] - 1];
                int[] newPlace = {current[0], current[1]}; // 현재 위치 복사

                // 최단 경로로 이동
                if (newPlace[0] != destination[0]) {
                    newPlace[0] += (newPlace[0] < destination[0]) ? 1 : -1;
                } else if (newPlace[1] != destination[1]) {
                    newPlace[1] += (newPlace[1] < destination[1]) ? 1 : -1;
                }

                robotPositions.put(i, newPlace);

                // 목적지 도달 시 다음 경로로 이동
                if (newPlace[0] == destination[0] && newPlace[1] == destination[1]) {
                    robotsGoing[i]++;
                }

                // 좌표 키로 충돌 체크
                String positionKey = newPlace[0] + "," + newPlace[1];
                positionCount.put(positionKey, positionCount.getOrDefault(positionKey, 0) + 1);
            }

            // 충돌 횟수 계산
            for (int count : positionCount.values()) {
                if (count > 1) {
                    answer++; // 해당 좌표에서 충돌 한 번만 추가
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}}; // y, x
        int[][] routes = new int[][]{{4, 2}, {1, 3}, {4, 2}, {4, 3}}; // 로봇 경로

        System.out.println(solution(points, routes));
    }
}
