package programmers;

public class Pm120956 {
    public static int solution(String[] babbling) {
        int answer = 0;

        String[] baby = {"aya", "ye", "woo", "ma"};

        for(String bab : babbling) {
            for(String b : baby) {
                bab = bab.replaceAll(b,"A");
            }
            boolean canSay = true;
            for(int i = 0; i < bab.length(); i++) {
                if(bab.charAt(i) >= 'a' && bab.charAt(i) <= 'z') {
                    canSay = false;
                    break;
                }
            }
            if(canSay) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};

        System.out.println(solution(babbling));

    }
}
