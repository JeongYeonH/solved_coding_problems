package 레벨3_문제;

import java.util.*;

public class 보석_쇼핑 {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        int[] answer = new int[2];
        for(String gem : gems){
            set.add(gem);
        }
        
        Map<String, Integer> tempMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int gap = gems.length;
        tempMap.put(gems[start], start);
        
        while(end < gems.length - 1){            
            if(tempMap.size() == set.size()){
                if(gap > (end-start)){
                    gap = end - start;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }            
            }
            
            end++;
            tempMap.put(gems[end], end);
            
            while(tempMap.get(gems[start]) > start){
                start++;
            }
            
            if(tempMap.size() == set.size()){
                if(gap > (end-start)){
                    gap = end - start;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                } 
            }
        }
        return answer;
    }
}
