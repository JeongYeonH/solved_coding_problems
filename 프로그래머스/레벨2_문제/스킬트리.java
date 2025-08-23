package 레벨2_문제;

import java.util.*;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < skill.length(); i++){
            map.put(skill.substring(i, i + 1), i);
        }
        
        for(String skille : skill_trees){
            int storeIdx = -1;
            boolean isAble = true;
            
            for(int i = 0; i < skille.length(); i++){
                String str = skille.substring(i, i + 1);
                
                if(!map.containsKey(str)) continue;
                
                int idx =  map.get(str);
                
                if(idx == storeIdx + 1){
                    storeIdx = idx;
                }else{
                    isAble = false;
                    break;
                }
            }
            if(isAble) answer++;
        }
        return answer;
    }
}
