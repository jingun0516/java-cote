package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bj5635 {
    public static class Human implements Comparable<Main.Human> {
        private String name;
        private int year;
        private int month;
        private int day;

        public Human(String name, int year, int month, int day) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public int compareTo(Main.Human o) {
            if(this.year != o.year) {
                return Integer.compare(this.year, o.year);
            }
            if(this.month != o.month) {
                return Integer.compare(this.month, o.month);
            }

            return Integer.compare(this.day, o.day);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Main.Human> humans = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String name = sc.next();
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();

            humans.add(new Main.Human(name, year, month, day));
        }

        Collections.sort(humans);

        System.out.println(humans.get(humans.size() - 1).getName());
        System.out.println(humans.get(0).getName());
    }
}
