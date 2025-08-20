package 레벨1_문제;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int phoneKetType : nums){
            if(map.containsKey(phoneKetType)){
                int amount = map.get(phoneKetType);
                map.put(phoneKetType, amount +1);
            }else{
                map.put(phoneKetType, 1);
            }
        }
        int total = nums.length/2;       
        int answer = map.size() < total ? map.size() : total;
        return answer;
    }
}
