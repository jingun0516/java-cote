package programmers;

public class Pm147355 {
    public static int solution(String t, String p) {
        int answer = 0;

        int size = p.length();
        long pLong = Long.parseLong(p);

        for(int i = 0; i < t.length(); i++) {
            if(i + size <= t.length()) {
                String temp = t.substring(i, i + size);
                long tempLong = Long.parseLong(temp);
                System.out.println(temp);

                if(tempLong <= pLong) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String t = "10203";
        String p = "15";

        solution(t, p);
    }
}
