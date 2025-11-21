package 레벨3_문제;

public class 산_모양_타일링 {
    public int solution(int n, int[] tops) {
        int answer = 0;        
        int[][] dp = new int[n][4];
        
        if(tops[0] == 1){
            dp[0] = new int[]{1, 1, 1, 1};
        }else if(tops[0] == 0){
            dp[0] = new int[]{1, 1, 1, 0};
        }
                
        for(int i = 1; i < n; i++){
            int[] prev = dp[i - 1];
            
            int nothing = prev[0];
            int posA = prev[1];
            int posB = prev[2];
            int posC = prev[3];
            
            if(tops[i] == 0){            
                for(int j = 0; j < 3; j++){
                    dp[i][j] += nothing;
                    dp[i][j] += posA;
                    dp[i][j] += posC;
                    
                    if(j != 1) dp[i][j] += posB;
                }
            }else if(tops[i] == 1){
                for(int j = 0; j < 4; j++){
                    dp[i][j] += nothing;
                    dp[i][j] += posA;
                    dp[i][j] += posC;
                    
                    if(j != 1) dp[i][j] += posB;                    
                }
            }
            
            for(int j = 0; j < 4; j++){
                dp[i][j] = dp[i][j]%10007;
            }
        }
        
        for(int i = 0; i < 4; i++){
            answer += dp[n - 1][i];
        }
                
        return answer%10007;
    }    
}
