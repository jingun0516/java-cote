package programmers.needtocheck;

public class Pm150369 {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverySum = 0;
        int pickupSum = 0;

        for(int i = n - 1; i >= 0; i--) {
            int cnt = 0;
            deliverySum += deliveries[i];
            pickupSum += pickups[i];

            while(deliverySum > 0 || pickupSum > 0) {
                deliverySum -= cap;
                pickupSum -= cap;
                cnt++;
            }
            answer += (long) (i + 1) * 2 * cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = new int[]{1, 0, 3, 1, 2};
        int[] pickups = new int[]{0, 3, 0, 4, 0};

        System.out.println(solution(cap, n, deliveries, pickups));
    }
}

/*
당신은 일렬로 나열된 n개의 집에 택배를 배달하려 합니다.
배달할 물건은 모두 크기가 같은 재활용 택배 상자에 담아 배달하며,
배달을 다니면서 빈 재활용 택배 상자들을 수거하려 합니다.
배달할 택배들은 모두 재활용 택배 상자에 담겨서 물류창고에 보관되어 있고,
i번째 집은 물류창고에서 거리 i만큼 떨어져 있습니다.
또한 i번째 집은 j번째 집과 거리 j - i만큼 떨어져 있습니다. (1 ≤ i ≤ j ≤ n)
트럭에는 재활용 택배 상자를 최대 cap개 실을 수 있습니다.
트럭은 배달할 재활용 택배 상자들을 실어 물류창고에서 출발해 각 집에 배달하면서,
빈 재활용 택배 상자들을 수거해 물류창고에 내립니다.
각 집마다 배달할 재활용 택배 상자의 개수와 수거할 빈 재활용 택배 상자의 개수를 알고 있을 때,
트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 구하려 합니다.
각 집에 배달 및 수거할 때, 원하는 개수만큼 택배를 배달 및 수거할 수 있습니다.


 */