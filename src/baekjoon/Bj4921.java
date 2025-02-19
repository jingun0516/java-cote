package baekjoon;

import java.util.Scanner;

public class Bj4921 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        while (true) {
            cnt++;
            String s = sc.nextLine();
            if(s.equals("0")) {
                break;
            }

            boolean check = false;

            if(s.charAt(0) != '1' || s.charAt(s.length() - 1) != '2') {
                check = true;
            }

            int[] cnts = new int[9];
            cnts[s.charAt(0) - '0']++;

            for(int i = 1; i < s.length(); i++) {
                if(check) {
                    break;
                }

                int prev = s.charAt(i-1) - '0';
                int num = s.charAt(i) - '0';
                cnts[num]++;

                switch(prev) {
                    case 1 -> {
                        if(num != 4 && num != 5) {
                            check = true;
                        }
                    }

                    case 2 -> {
                        check = true;
                    }

                    case 3-> {
                        if(num != 4 && num != 5) {
                            check = true;
                        }
                    }

                    case 4 -> {
                        if(num != 2 && num != 3) {
                            check = true;
                        }
                    }

                    case 5 -> {
                        if(num != 8) {
                            check = true;
                        }
                    }

                    case 6 -> {
                        if(num != 2 && num != 3) {
                            check = true;
                        }
                    }

                    case 7 -> {
                        if(num != 8) {
                            check = true;
                        }
                    }

                    case 8 -> {
                        if(num != 6 && num != 7) {
                            check = true;
                        }
                    }
                }
            }
            if(cnts[1] != cnts[2] || cnts[5] != cnts[6]) {
                check = true;
            }

            String answer = check ? "NOT" : "VALID";
            System.out.println(cnt + ". " + answer);
        }
    }
}
