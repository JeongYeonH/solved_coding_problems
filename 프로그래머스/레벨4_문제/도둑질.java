package 레벨4_문제;

public class 도둑질 {
    public int solution(int[] money) {
        
        if(money.length == 1) return money[0];
        else if(money.length == 2) return Math.max(money[0], money[1]);
        
        int[] dp1 = new int[money.length - 1];
        int[] dp2 = new int[money.length - 1];
        dp1[0] = money[0];
        dp2[0] = money[1];
        
        for(int i = 1; i < dp1.length; i++){
            if(i == 1) dp1[i] = Math.max(dp1[0], money[i]);
            else{
                dp1[i] = Math.max(dp1[i-1], money[i] + dp1[i -2]);
            }
        }
        
        for(int i = 1; i < dp2.length; i++){
            if(i == 1) dp2[i] = Math.max(dp2[0], money[i+1]);
            else{
                dp2[i] = Math.max(dp2[i-1], money[i + 1] + dp2[i -2]);
            }
        }
    
        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }
}
