package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bj6917 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');

        String str = "";
        while(true)
        {
            str = sc.nextLine();
            if(str.equals("quit!")) break;

            if(str.length() > 3 && str.endsWith("or")) {
                if(!vowel.contains(str.charAt(str.length() - 3))) {
                    str = str.substring(0, str.length() - 2) + "our";
                }
            }
            System.out.println(str);
        }
        
    }
}


/*
Americans spell differently from Canadians.
Americans write neighbor and color while Canadians write neighbour and colour.
Write a program to help Americans translate to Canadian.

Your program should interact with the user in the following way.
The user should type a word (not to exceed 64 letters) and if the word appears to use American spelling,
the program should echo the Canadian spelling for the same word.
If the word does not appear to use American spelling, it should be output without change.
When the user types quit! the program should terminate.

The rules for detecting American spelling are quite naive:
If the word has more than four letters and has a suffix consisting of a consonant followed by or,
you may assume it is an American spelling, and that the equivalent Canadian spelling replaces the or by our.
Note: you should treat the letter y as a vowel.

최대 64자의 단어, 미국 영어 같으면 캐나다 영어로 바꿔라
미국 영어처럼 보이지 않으면 그냥 출력해라
quit!을 입력하면 프로그램은 종료된다
// 4글자 넘고, 자음 + or로 끝나면 our로 바꾸기
// y는 모음으로 간주


 */