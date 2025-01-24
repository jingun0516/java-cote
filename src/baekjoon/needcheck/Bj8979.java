package baekjoon.needcheck;

import java.util.*;

public class Bj8979 {
    // 메달 정보를 담는 클래스
    static class Medal implements Comparable<Medal> {
        int gold, silver, bronze;

        public Medal(int gold, int silver, int bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Medal o) {
            if (this.gold != o.gold) {
                return Integer.compare(o.gold, this.gold); // 금메달 내림차순
            }
            if (this.silver != o.silver) {
                return Integer.compare(o.silver, this.silver); // 은메달 내림차순
            }
            return Integer.compare(o.bronze, this.bronze); // 동메달 내림차순
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Medal medal = (Medal) o;
            return gold == medal.gold && silver == medal.silver && bronze == medal.bronze;
        }

        @Override
        public int hashCode() {
            return Objects.hash(gold, silver, bronze);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 국가 수
        int K = sc.nextInt(); // 랭킹을 알고 싶은 국가

        // TreeMap으로 국가별 메달 정렬
        Map<Medal, Integer> maps = new TreeMap<>();
        Medal findMedal = null;

        for (int i = 0; i < N; i++) {
            int nation = sc.nextInt();
            int gold = sc.nextInt();
            int silver = sc.nextInt();
            int bronze = sc.nextInt();

            Medal medal = new Medal(gold, silver, bronze);

            // 랭킹을 알고 싶은 국가의 메달 정보 저장
            if (nation == K) {
                findMedal = medal;
            }

            // 중복 메달 카운트
            maps.put(medal, maps.getOrDefault(medal, 0) + 1);
        }

        // 랭킹 계산
        Map<Medal, Integer> rank = new HashMap<>();
        int tempRank = 1;

        for (Map.Entry<Medal, Integer> entry : maps.entrySet()) {
            Medal medal = entry.getKey();
            int count = entry.getValue();

            rank.put(medal, tempRank); // 현재 랭킹 저장
            tempRank += count;        // 다음 랭킹 계산
        }

        // 출력: findMedal의 랭킹
        System.out.println(rank.get(findMedal));
    }
}
