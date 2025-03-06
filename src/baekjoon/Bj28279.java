package baekjoon;

import java.io.*;
import java.util.*;

public class Bj28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);

            switch (num) {
                case 1 -> deque.addFirst(Integer.parseInt(input[1]));
                case 2 -> deque.addLast(Integer.parseInt(input[1]));
                case 3 -> sb.append(deque.isEmpty() ? -1 : deque.removeFirst()).append("\n");
                case 4 -> sb.append(deque.isEmpty() ? -1 : deque.removeLast()).append("\n");
                case 5 -> sb.append(deque.size()).append("\n");
                case 6 -> sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                case 7 -> sb.append(deque.isEmpty() ? -1 : deque.getFirst()).append("\n");
                case 8 -> sb.append(deque.isEmpty() ? -1 : deque.getLast()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
