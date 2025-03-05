package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bj9933 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<String> passwords = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String password = sc.nextLine();

            passwords.add(password);
        }


        for(int i = 0; i < n; i++) {
            String password = passwords.get(i);

            if(passwords.contains(reverseString(password))) {
                System.out.print(password.length() + " ");
                System.out.println(password.charAt(password.length()/2));
                return;
            }
        }
    }

    public static String reverseString(String str) {
        StringBuilder reversedStr = new StringBuilder();

        for(int i = str.length() - 1; i >= 0; i--) {
            reversedStr.append(str.charAt(i));
        }

        return reversedStr.toString();
    }
}
