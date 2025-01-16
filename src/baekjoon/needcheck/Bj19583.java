package baekjoon.needcheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Bj19583 {
    public static int strToTime(String str) {
        String[] times = str.split(":");
        int hh = Integer.valueOf(times[0]);
        int mm = Integer.valueOf(times[1]);
        return hh * 60 + mm;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] words = str.split(" ");
        String S = words[0];
        String E = words[1];
        String Q = words[2];

        int sTime = strToTime(S);
        int eTime = strToTime(E);
        int qTime = strToTime(Q);

        Set<String> set = new HashSet<>();
        int answer = 0;

        String input = null;
        while ((input = br.readLine()) != null) {
            String[] parts = input.split(" ");
            int time = strToTime(parts[0]);
            String nickName = parts[1];

            if (!set.contains(nickName)) {
                if (time <= sTime) {
                    set.add(nickName);
                }
            } else {
                if (time >= eTime && time <= qTime) {
                    set.remove(nickName);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
