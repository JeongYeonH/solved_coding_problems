package 레벨2_문제;

import java.util.*;

public class 비밀_코드_해독 {
    int count = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        Set<Integer> set = new HashSet<>();
        comb(n, set, 1, q, ans);

        return count;
    }
    
    public void comb(int n, Set<Integer> set, int start, int[][] q, int[] ans){
        if(set.size() >= 5){
            boolean right = is_right(set, q, ans);
            if(right) count++;
            return;
        }
        
        for(int i = start; i <= n; i++){
            set.add(i);
            comb(n, set, i + 1, q, ans);
            set.remove(i);
        }
    }
    
    public boolean is_right(Set<Integer> set, int[][] q, int[] ans){
        
        for(int i = 0; i < ans.length; i++){
            int[] curr_q = q[i];
            int an = ans[i];
            int match = 0;
            
            for(int j = 0; j < curr_q.length; j++){
                if(set.contains(curr_q[j])) match++;
            }
            
            if(match != an) return false;
        }
        
        return true;
    }    
}
