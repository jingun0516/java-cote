package programmers;

import java.util.*;

public class Pm92342 {
    static List<int[]> arrays = new ArrayList<>();

    // 화살 분배 함수
    public static void distribute(int remaining, int slots, int[] result, int index) {
        if (index == slots - 1) {
            result[index] = remaining;
            arrays.add(result.clone());
            return;
        }

        for (int i = 0; i <= remaining; i++) {
            result[index] = i;
            distribute(remaining - i, slots, result, index + 1);
        }
    }

    // 점수 비교 시 낮은 점수 우선
    private static boolean isBetterResult(int[] candidate, int[] currentBest) {
        for (int i = 10; i >= 0; i--) {
            if (candidate[i] > currentBest[i]) return true;
            if (candidate[i] < currentBest[i]) return false;
        }
        return false;
    }

    public static int[] solution(int n, int[] info) {
        int[] answer = new int[11];

        // 가능한 모든 화살 배치 생성
        distribute(n, 11, new int[11], 0);

        int maxScoreDiff = 0;
        int[] bestResult = {-1};

        for (int[] lion : arrays) {
            int lScore = 0, aScore = 0;

            // 점수 계산
            for (int i = 0; i < 11; i++) {
                if (lion[i] > info[i]) { // 라이언이 이긴 경우
                    lScore += 10 - i;
                } else if (info[i] > 0) { // 어피치가 점수를 가져간 경우
                    aScore += 10 - i;
                }
            }

            // 라이언이 이긴 경우의 점수 차 비교
            if (lScore > aScore) {
                int scoreDiff = lScore - aScore;

                // 점수 차가 더 크거나 낮은 점수를 더 많이 맞힌 경우 업데이트
                if (scoreDiff > maxScoreDiff || (scoreDiff == maxScoreDiff && isBetterResult(lion, bestResult))) {
                    maxScoreDiff = scoreDiff;
                    bestResult = lion.clone();
                }
            }
        }

        return bestResult;
    }

    public static void main(String[] args) {
        int n = 1;
        int[] info = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] answer = solution(n, info);

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }
}
