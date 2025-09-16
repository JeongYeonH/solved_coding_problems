package 레벨2_문제;

public class 멀리_뛰기 {
    public long solution(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        
        for(int i = 2; i < n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        
        return dp[n - 1];
    }
}
