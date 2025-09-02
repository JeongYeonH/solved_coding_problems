package 레벨3_문제;

public class 스티커_모으기 {
    public int solution(int sticker[]) {
        
        if(sticker.length == 1) return sticker[0];
        else if(sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        
        int[] dp1 = new int[sticker.length - 1];
        int[] dp2 = new int[sticker.length - 1];
        dp1[0] = sticker[0];
        dp2[0] = sticker[1];
        
        for(int i = 1; i < dp1.length; i++){
            if(i == 1) dp1[i] = Math.max(dp1[0], sticker[i]);
            else{
                dp1[i] = Math.max(dp1[i-1], sticker[i] + dp1[i -2]);
            }
        }
        
        for(int i = 1; i < dp2.length; i++){
            if(i == 1) dp2[i] = Math.max(dp2[0], sticker[i+1]);
            else{
                dp2[i] = Math.max(dp2[i-1], sticker[i + 1] + dp2[i -2]);
            }
        }
    
        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }
}
