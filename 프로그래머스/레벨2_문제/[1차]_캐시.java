package 레벨2_문제;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String tempCity : cities){
            if(cacheSize == 0){
                answer += 5;
                continue;
            }
            
            String city = tempCity.toLowerCase();
            if(map.size() < cacheSize){
                if(map.containsKey(city)){
                    map.put(city, 0);
                    answer++;
                }else{
                    map.put(city, 0);
                    answer += 5;
                }
                
            }else if(map.size() >= cacheSize){
                if(map.containsKey(city)){
                    map.put(city, 0);
                    answer++;
                }else{
                    int val = 0;
                    String maxCity = null;
                    for(Map.Entry<String, Integer> ch : map.entrySet()){
                        String chCity = ch.getKey();
                        int value = ch.getValue();
                        if(value > val){
                            val = value;
                            maxCity = chCity;
                        }
                    }
                    map.remove(maxCity);
                    map.put(city, 0);
                    answer += 5;
                }
            }
            
            for(Map.Entry<String, Integer> ch : map.entrySet()){
                map.put(ch.getKey(), ch.getValue() + 1);
            }

        }
        return answer;
    }
}
