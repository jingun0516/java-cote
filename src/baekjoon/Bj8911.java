package baekjoon;

import java.util.Scanner;

public class Bj8911 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String str = sc.next();

            int minX = 0;
            int minY = 0;
            int maxX = 0;
            int maxY = 0;

            int direction = 0;
            int[] pos = new int[]{0, 0};

            for (int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case 'F':
                        pos = move(direction, pos, false);
                        break;
                    case 'B':
                        pos = move(direction, pos, true);
                        break;
                    case 'R':
                        direction = (direction + 1) % 4;
                        break;
                    case 'L':
                        direction = (direction - 1) < 0 ? 3 : direction - 1;
                        break;
                }

                minX = Math.min(minX, pos[0]);
                minY = Math.min(minY, pos[1]);
                maxX = Math.max(maxX, pos[0]);
                maxY = Math.max(maxY, pos[1]);
            }
            System.out.println((maxX - minX) * (maxY - minY));
        }
    }

    public static int[] move(int direction, int[] pos, boolean isReversed) {
        int x = pos[0];
        int y = pos[1];

        int k = isReversed ? -1 : 1;

        return switch (direction) {
            case 0 -> new int[]{x, y + k};  // 북
            case 1 -> new int[]{x + k, y};  // 동
            case 2 -> new int[]{x, y - k};  // 남
            case 3 -> new int[]{x - k, y};  // 서
            default -> new int[]{x, y};
        };
    }
}
