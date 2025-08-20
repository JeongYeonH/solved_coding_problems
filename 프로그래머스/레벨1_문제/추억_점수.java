package 레벨1_문제;

import java.util.HashMap;
import java.util.Map;

public class 추억_점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> yearMap = new HashMap<>();
        int length = photo.length;
        int[] answer = new int[length];
        for(int i=0; i< name.length; i++){
            yearMap.put(name[i], yearning[i]);
        }
        for(int i=0; i< photo.length; i++){
            int sum = 0;
            for(int j=0; j < photo[i].length; j++){
                String key = photo[i][j];
                Integer value = yearMap.get(key);
                int yearAmount = value != null ? value : 0;
                sum += yearAmount;
            }
            answer[i] = sum;
        }        
        return answer;
    }
}
