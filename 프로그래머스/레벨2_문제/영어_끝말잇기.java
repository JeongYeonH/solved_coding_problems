package 레벨2_문제;

import java.util.*;

public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        
        String prev = words[0];
        set.add(prev);
        int i;
        
        for(i = 1; i < words.length; i++){
            String curr = words[i];
            String last = prev.substring(prev.length() - 1);
            String begin = curr.substring(0, 1);
            
            if(!last.equals(begin) || set.contains(curr)){
                break;
            }else{
                set.add(curr);
                prev = curr;                
            }
            
        }
        
        if(i == words.length) return new int[]{0, 0};
        
        int count = (i + 1) % n != 0 ?  (i + 1)/n + 1 : (i + 1)/n;
        int order = (i + 1) % n != 0 ? (i + 1) % n : n;
        
        return new int[]{order, count};
    }
}
