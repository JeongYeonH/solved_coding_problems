package 레벨2_문제;

import java.util.*;
import java.util.stream.Collectors;

public class 귤_고르기 {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int tager : tangerine){
            if(map.containsKey(tager)){
                map.put(tager, map.get(tager)+1);
            }else{
                map.put(tager, 1);
            }
        }
        List<Integer> list = map.entrySet().stream()
            .map( e-> e.getValue())
            .collect(Collectors.toList());
        list.sort((a,b) -> Integer.compare(b, a));
        
        int total = 0;
        int i;
        for(i = 0; i < list.size(); i++){
            if(total >= k){
                break; 
            } 
            total += list.get(i);            
        }
        
        return i;
    }
}
