package programmers.needtocheck;

public class Pm181187 {
    public static long solution(int r1, int r2) {
        long answer = 0;

        for (long x = 1; x <= r2; x++) {
            long maxY = (long) Math.floor(Math.sqrt((long) r2 * r2 - x * x));
            long minY = (long) Math.ceil(Math.sqrt((long) r1 * r1 - x * x));

            answer += maxY - minY + 1;
        }

        return answer * 4;
    }

    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;

        System.out.println(solution(r1, r2));
    }
}
