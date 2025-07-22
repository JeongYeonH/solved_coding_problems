package 레벨2_문제;

import java.util.HashMap;
import java.util.Map;

public class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> dynamicMap = new HashMap<>();
        int answer = 0;
        
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }
        
        for(int i = 0; i < discount.length; i++){
            String target = discount[i];
            String removeTarget = i > 9 ? discount[i-10] : null;
            boolean able = true;
            dynamicMap.put(target, dynamicMap.getOrDefault(target, 0) + 1);
            
            if(i > 9){
                dynamicMap.put(removeTarget, dynamicMap.get(removeTarget) - 1);
            }
            
            for(Map.Entry<String, Integer> tempMap : map.entrySet()){
                int val = dynamicMap.getOrDefault(tempMap.getKey(), 0);
                if(val < tempMap.getValue()){
                    able = false;
                    break;
                }
            }
            
            if(able){
                answer++;
            }
        }
        return answer;
    }
}
