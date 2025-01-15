package programmers;

import java.util.*;

public class Pm72412 {
    static Map<String, List<Integer>> maps = new HashMap<>();

    public static void makeInfo(String[] info, String str, int cnt) {
        if(cnt == 4) {
            if(!maps.containsKey(str)) {
                maps.put(str, new ArrayList<>());
            }
            maps.get(str).add(Integer.parseInt(info[4]));
            return;
        }
        makeInfo(info, str + "-", cnt + 1);
        makeInfo(info, str + info[cnt], cnt + 1);
    }

    public static int binarySearch(String key, int score) {
        List<Integer> list = maps.get(key);
        int start = 0;
        int end = list.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(score > list.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for(int i = 0; i < info.length; i++) {
            String[] splitedInfo = info[i].split(" ");
            makeInfo(splitedInfo, "", 0);           // 가능한 모든 경우의 수
        }

        for(String key : maps.keySet()) {
            Collections.sort(maps.get(key));    // 각 key의 value들을 정렬
        }

        for(int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and", "");
            String[] splitedQuery = query[i].split(" ");
            String key = "";
            for(int j = 0; j < 4; j++) {
                key += splitedQuery[j];
            }
            int score = Integer.parseInt(splitedQuery[4]);
            answer[i] = maps.containsKey(key) ? binarySearch(key, score) : 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] info = new String[] {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String[] query = new String[] {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        int[] answer = solution(info, query);

        for(int ans : answer) {
            System.out.println(ans);
        }
    }
}
