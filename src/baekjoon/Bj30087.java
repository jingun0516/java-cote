package baekjoon;

import java.util.Scanner;

public class Bj30087 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            String str = sc.next();

            String answer = "";
            switch (str) {
                case "Algorithm" -> answer = "204";
                case "DataAnalysis" -> answer = "207";
                case "ArtificialIntelligence" -> answer = "302";
                case "CyberSecurity" -> answer = "B101";
                case "Network" -> answer = "303";
                case "Startup" -> answer = "501";
                case "TestStrategy" -> answer = "105";
            }

            System.out.println(answer);
        }
    }
}
