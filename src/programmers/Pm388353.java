package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Pm388353 {
    static String[] storage = new String[]{
            "AZWQY", "CAABX", "BBDDA", "ACACA"
    };

    static String[] requests = new String[]{
            "A", "BB", "A"
    };

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static int solution(String[] storage, String[] requests) {
        int answer = 0;

        String[] newStorage = new String[storage.length + 2];
        int storageLen = storage[0].length();
        StringBuilder newStorageStr = new StringBuilder();
        newStorageStr.append("0".repeat(Math.max(0, storageLen + 2)));
        newStorage[0] = newStorageStr.toString();
        newStorage[newStorage.length - 1] = newStorageStr.toString();

        for(int i = 1; i < newStorage.length - 1; i++){
            String str = "0" + storage[i - 1] + "0";
            newStorage[i] = str;
        }


        for (String request : requests) {
            char text = request.charAt(0);

            if (request.length() >= 2) {
                for (int j = 1; j < newStorage.length - 1; j++) {
                    for (int k = 1; k < newStorage[j].length() - 1; k++) {
                        if (newStorage[j].charAt(k) == text) {
                            StringBuilder sb = new StringBuilder(newStorage[j]);
                            sb.setCharAt(k, '0');
                            newStorage[j] = sb.toString();
                        }
                    }
                }
            } else {
                Queue<int[]> qu = new LinkedList<>();
                Queue<int[]> removeQu = new LinkedList<>();
                boolean[][] visited = new boolean[newStorage.length][newStorage[0].length()];
                qu.add(new int[]{0, 0});
                visited[0][0] = true;

                while (!qu.isEmpty()) {
                    int[] curr = qu.poll();
                    int y = curr[0];
                    int x = curr[1];

                    for (int j = 0; j < 4; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];

                        if (ny >= 0 && nx >= 0 && ny < newStorage.length && nx < newStorage[0].length()) {
                            if (!visited[ny][nx] && newStorage[ny].charAt(nx) == '0') {
                                visited[ny][nx] = true;
                                qu.add(new int[]{ny, nx});
                            } else if (newStorage[ny].charAt(nx) == text) {
                                removeQu.add(new int[]{ny, nx});
                            }
                        }
                    }
                }

                while (!removeQu.isEmpty()) {
                    int[] curr = removeQu.poll();
                    int y = curr[0];
                    int x = curr[1];

                    StringBuilder sb = new StringBuilder(newStorage[y]);
                    sb.setCharAt(x, '0');
                    newStorage[y] = sb.toString();
                }
            }
        }

        for(int i = 1; i < newStorage.length - 1; i++) {
            for(int j = 1; j < newStorage[i].length() - 1; j++) {
                if(newStorage[i].charAt(j) != '0') {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(storage, requests));
    }

}
