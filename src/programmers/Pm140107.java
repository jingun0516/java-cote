package programmers;

public class Pm140107 {
    public static long solution(int k, int d) {
        long count = 0;
        long maxX = d / k; // x축 최대 이동 가능 단위

        for (long a = 0; a <= maxX; a++) {
            long x = a * k;
            long maxYSquared = (long) d * d - x * x; // 가능한 y^2의 최대값
            long maxY = (long) Math.sqrt(maxYSquared); // y의 최대값
            count += maxY / k + 1; // 가능한 y 값의 개수 누적
        }

        return count;
    }

    public static void main(String[] args) {
        int k = 2;
        int d = 4;
        System.out.println(solution(k, d));
    }
}
