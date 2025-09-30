package 레벨2_문제;

import java.util.*;

public class 다른_사람의_풀이 {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        String[] alphabet = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for(int i = 0; i < alphabet.length; i++){
            map.put(alphabet[i], i + 1);
        }

        int idx = 0;

        while(idx < msg.length()){
            int start = idx;

            while(map.containsKey(msg.substring(start, idx + 1))){
                idx++;
                if(idx >= msg.length()) break;
            }

            String key = msg.substring(start, idx);
            int val = map.get(key);

            list.add(val);

            if(idx + 1 >= msg.length()) continue;
            map.put(msg.substring(start, idx + 1), map.size() + 1);
        }

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
