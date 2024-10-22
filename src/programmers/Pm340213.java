package programmers;

import java.util.Scanner;

public class Pm340213 {
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        String[] videos = video_len.split(":");
        int video_lenT = Integer.parseInt(videos[0]) * 60 + Integer.parseInt(videos[1]);

        String[] poss = pos.split(":");
        int posT = Integer.parseInt(poss[0]) * 60 + Integer.parseInt(poss[1]);

        String[] op_starts = op_start.split(":");
        int op_startT = Integer.parseInt(op_starts[0]) * 60 + Integer.parseInt(op_starts[1]);

        String[] op_ends = op_end.split(":");
        int op_endT = Integer.parseInt(op_ends[0]) * 60 + Integer.parseInt(op_ends[1]);

        for(String command : commands) {
            if(posT >= op_startT && posT <= op_endT) {
                posT = op_endT;
            }

            if(command.equals("prev")) {
                posT -= 10;
                if(posT < 0) {
                    posT = 0;
                }
            } else {
                posT += 10;
                if(posT >= video_lenT) {
                    posT = video_lenT;
                }
            }
            if(posT >= op_startT && posT <= op_endT) {
                posT = op_endT;
            }
        }

        int posH = posT / 60;
        int posM = (posT - posH * 60);

        String answerH = Integer.toString(posH);
        if(answerH.length() == 1) {
            answerH = "0" + answerH;
        }

        String answerM = Integer.toString(posM);
        if(answerM.length() == 1) {
            answerM = "0" + answerM;
        }

        answer = answerH + ":" + answerM;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String video_len = "10:55";
        String pos = "00:05";
        String op_start = "00:15";
        String op_end = "06:55";
        String[] commands = {"prev", "next", "prev"};

        System.out.println(solution(video_len, pos, op_start, op_end, commands));
    }
}
