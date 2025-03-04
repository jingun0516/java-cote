package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bj4335 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Temp> temps = new ArrayList<>();

        while(true){
            int n = sc.nextInt();
            sc.nextLine();

            if(n == 0) {
                break;
            }

            String str = sc.nextLine();

            if(str.equals("right on")) {
                boolean found = false;
                for (Temp temp : temps) {
                    int num = temp.num;
                    String strs = temp.str;
                    if ((num >= n && !strs.equals("too high")) || (num <= n && !strs.equals("too low"))) {
                        found = true;
                        break;
                    }
                }
                if(found) {
                    System.out.println("Stan is dishonest");
                } else {
                    System.out.println("Stan may be honest");
                }
                temps.clear();
            } else {
                temps.add(new Temp(n, str));
            }
        }

    }

    public static class Temp {
        int num;
        String str;

        public Temp(int num, String str) {
            this.num = num;
            this.str = str;
        }

        public int getNum() {
            return num;
        }

        public String getStr() {
            return str;
        }
    }
}
