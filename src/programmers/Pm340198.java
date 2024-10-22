package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Pm340198 {    public static int solution(int[] mats, String[][] park) {
    int answer = -1;

    Integer[] matsArray = Arrays.stream(mats)
            .boxed()
            .toArray(Integer[]::new);

    Arrays.sort(matsArray, Collections.reverseOrder());

    int row = park.length;
    int col = park[0].length;

    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            if(!park[i][j].equals("-1")) {
                continue;
            }
            for (int matSize : matsArray) {
                boolean canPlace = true;

                if(i + matSize > row || j + matSize > col) {
                    continue;
                }

                for (int i2 = i; i2 < i + matSize; i2++) {
                    boolean isFailed = false;
                    for (int j2 = j; j2 < j + matSize; j2++) {
                        if(!park[i2][j2].equals("-1")) {
                            canPlace = false;
                            isFailed = true;
                            break;
                        }
                    }
                    if(isFailed) {
                        break;
                    }
                }
                if (canPlace) {
                    answer = Math.max(answer, matSize);
                    break;
                }
            }
        }
    }

    return answer;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] mats = {5, 3, 2};

        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

        System.out.println(solution(mats, park));
    }
}
