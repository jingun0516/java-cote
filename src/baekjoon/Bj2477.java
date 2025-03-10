package baekjoon;

import java.util.Scanner;

public class Bj2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        int maxWidth = 0;
        int maxHeight = 0;
        int wIndex = 0;
        int hIndex = 0;
        int[][] arr = new int[6][2];

        // 1, 2 동서  3, 4 남북
        for(int i = 0; i < 6; i++) {
            int direction = sc.nextInt();
            int length = sc.nextInt();

            arr[i] = new int[]{direction, length};
        }

        // 가장 긴 w / h 옆에는 무조건 작은 w / h를 뺀 값이 있음
        for(int i = 0; i < 6; i++) {
            int direction = arr[i][0];
            int length = arr[i][1];

            if(direction == 1 || direction == 2) {
                if(length > maxWidth) {
                    maxWidth = length;
                    wIndex = i;
                }
            } else {
                if(length > maxHeight) {
                    maxHeight = length;
                    hIndex = i;
                }
            }
        }

        // 작은 h 구하기
        int leftH = 0;
        int rightH = 0;

        if(wIndex == 0) {
            leftH = arr[5][1];
            rightH = arr[wIndex+1][1];
        } else if(wIndex == 5){
            leftH = arr[wIndex-1][1];
            rightH = arr[0][1];
        } else {
            leftH = arr[wIndex-1][1];
            rightH = arr[wIndex+1][1];
        }

        int minHeight = maxHeight - Math.min(leftH, rightH);

        // 작은 w 구하기
        int leftW = 0;
        int rightW = 0;

        if(hIndex == 0) {
            leftW = arr[5][1];
            rightW = arr[hIndex+1][1];
        } else if(hIndex == 5){
            leftW = arr[hIndex-1][1];
            rightW = arr[0][1];
        } else {
            leftW = arr[hIndex-1][1];
            rightW = arr[hIndex+1][1];
        }

        int minWidth = maxWidth - Math.min(leftW, rightW);

        int answer = (maxWidth * maxHeight - minWidth * minHeight) * k;
        System.out.println(answer);
    }
}
