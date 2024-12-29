package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bj10448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        List<Integer> nums = new ArrayList<>();

        for(int i = 1; i * (i + 1) / 2 <= 1000; i++) {
            nums.add(i * (i + 1) / 2);
        }

        for(int i = 0; i < T; i++) {
            int K = sc.nextInt();
            boolean found = false;

            for(Integer a : nums) {
                for(Integer b : nums) {
                    for(Integer c : nums) {
                        if(a + b + c == K) {
                            System.out.println(1);
                            found = true;
                            break;
                        }
                    }
                    if(found)  {
                        break;
                    }
                }
                if(found) {
                    break;
                }
            }
            if(!found) {
                System.out.println(0);
            }
        }
    }
}
