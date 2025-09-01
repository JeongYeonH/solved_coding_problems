package 레벨2_문제;

import java.util.*;

public class 줄_서는_방법 {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[n];
        int index = 0;
        
        long followed = 0;
        
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        
        while(index < n){
            long size = factorial(n - (1 + index));
            int i;
            
            for(i = 1; i <= list.size(); i++){
                long amt = followed + i*size;
                if(amt >= k){
                    followed = amt - size;
                    break;
                } 
            }
            
            answer[index] = list.get(i - 1);
            list.remove(i - 1);
            index++;
        }

        
        return answer;
    }
    
    public long factorial(int num){
        long j = 1;
        int idx = 1;
        while(idx < num){
            idx++;
            j *= idx;
        }
        
        return j;
    }
}
