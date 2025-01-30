package baekjoon;

import java.util.Scanner;

public class Bj4659 {
    public static void print(boolean acceptable, String str) {
        String strToPrint = "<" + str + ">";

        System.out.print(strToPrint);

        if(!acceptable) {
            System.out.println(" is not acceptable.");
        } else {
            System.out.println(" is acceptable.");
        }
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.next();

            if(str.equals("end")) {
                break;
            }

            if(!str.contains("a") && !str.contains("e") && !str.contains("i") && !str.contains("o") && !str.contains("u")) {
                print(false, str);
                continue;
            }

            boolean isDuplicated = false;
            for(int i = 0; i < str.length() - 1; i++) {
                if(str.charAt(i) != 'e' && str.charAt(i) != 'o' && str.charAt(i) == str.charAt(i + 1)) {
                    isDuplicated = true;
                    break;
                }
            }

            if(isDuplicated) {
                print(false, str);
                continue;
            }

            boolean isTriple = false;

            for(int i = 0; i < str.length() - 2; i++) {
                if(isVowel(str.charAt(i)) && isVowel(str.charAt(i + 1)) && isVowel(str.charAt(i + 2))) {
                    isTriple = true;
                    break;
                }
                if(!isVowel(str.charAt(i)) && !isVowel(str.charAt(i + 1)) && !isVowel(str.charAt(i + 2))) {
                    isTriple = true;
                    break;
                }
            }
            if(isTriple) {
                print(false, str);
                continue;
            }

            print(true, str);
        }
    }
}
