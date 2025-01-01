package programmers;

import java.util.*;

public class Pm42890 {
    public static int solution(String[][] relation) {
        int rowCount = relation.length;
        int colCount = relation[0].length;

        List<Integer> candidateKeys = new ArrayList<>();

        // 모든 조합 생성 (1부터 colCount까지)
        for (int i = 1; i < (1 << colCount); i++) {
            // 유일성 검사
            if (isUnique(i, relation, rowCount, colCount)) {
                // 최소성 검사
                if (isMinimal(i, candidateKeys)) {
                    candidateKeys.add(i);
                }
            }
        }

        return candidateKeys.size();
    }

    // 유일성 검사
    private static boolean isUnique(int subset, String[][] relation, int rowCount, int colCount) {
        Set<String> uniqueRows = new HashSet<>();

        for (int row = 0; row < rowCount; row++) {
            StringBuilder key = new StringBuilder();
            for (int col = 0; col < colCount; col++) {
                if ((subset & (1 << col)) != 0) { // 선택된 속성만 추가
                    key.append(relation[row][col]).append(",");
                }
            }
            uniqueRows.add(key.toString());
        }

        return uniqueRows.size() == rowCount;
    }

    // 최소성 검사
    private static boolean isMinimal(int subset, List<Integer> candidateKeys) {
        for (int key : candidateKeys) {
            if ((key & subset) == key) { // 후보키가 현재 조합의 부분 집합인지 확인
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };

        System.out.println(solution(relation));
    }
}
