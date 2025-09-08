package 레벨3_문제;

import java.util.*;

public class N으로_표현 {
    public int solution(int N, int number) {       
        Set<Integer>[] dp = new HashSet[9]; 
        for (int i = 1; i <= 8; i++) dp[i] = new HashSet<>();
        dp[1].add(N);
        
        if(N == number) return 1;
        
        for (int i = 2; i <= 8; i++) {
            dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            for(int j = 1; j < i; j++){
                for(int x : dp[j]){
                    for(int y : dp[i - j]){
                        dp[i].add(x + y);
                        dp[i].add(x - y);
                        dp[i].add(x * y);
                        if (y != 0) dp[i].add(x / y);
                    }
                }
            }
            
            if (dp[i].contains(number)) return i;
        }
        
        return -1;
    }
}
