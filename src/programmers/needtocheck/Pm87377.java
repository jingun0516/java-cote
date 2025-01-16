package programmers.needtocheck;

import java.util.HashSet;
import java.util.Set;

public class Pm87377 {
    public static String[] solution(int[][] line) {
        Set<String> intersections = new HashSet<>();

        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for (int i = 0; i < line.length; i++) {
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];

                long det = A*D - B*C;
                long forX = B*F - E*D;
                long forY = E*C - A*F;

                if(det == 0 || forX % det != 0 || forY % det != 0) {  // 평행하거나 정수가 아닐 경우
                    continue;
                }

                long intX = forX / det;
                long intY = forY / det;

                maxX = Math.max(intX, maxX);
                maxY = Math.max(intY, maxY);
                minX = Math.min(intX, minX);
                minY = Math.min(intY, minY);

                intersections.add(intX + "," + intY);
            }
        }

        long width = maxX - minX + 1;
        long height = maxY - minY + 1;

        String[] answer = new String[(int)height];

        for (int i = 0; i < height; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < width; j++) {
                sb.append(".");
            }
            answer[i] = sb.toString();
        }

        for (String point : intersections) {
            String[] parts = point.split(",");
            long x = Long.parseLong(parts[0]) - minX;
            long y = maxY - Long.parseLong(parts[1]);

            StringBuilder sb = new StringBuilder(answer[(int)y]);
            sb.setCharAt((int)x, '*');
            answer[(int)y] = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] answer = solution(line);

        for (String ans : answer) {
            System.out.println(ans);
        }
    }
}
