package 레벨2_문제;

import java.util.Arrays;

public class 양궁대회 {
    int gap = 0;
    int last = 0;
    int[] ans = new int[11];
    boolean answerExist = false;
    
    public int[] solution(int n, int[] info) {
        int[] match = new int[11];
        
        comb(n, info, match, 0, 0);
        
        if(!answerExist) return new int[]{-1};

        return ans;
    }
    
    public void comb(int n, int[] info, int[] match, int start, int gainedScores){
        if(n <= 0){
            int losedScores = 0;
            int currLast = 0;
            
            for(int i = 0; i <= 10; i++){
                if(info[i] >= match[i] && info[i] != 0) losedScores += (10 - i);
                if(match[i] != 0) currLast = i;
            }
            
            if(gainedScores - losedScores > gap){
                gap = gainedScores - losedScores;
                last = currLast;          
                answerExist = true;
                ans = Arrays.copyOf(match, match.length);
            }else if(gainedScores - losedScores == gap && currLast > last && gap != 0){
                last = currLast;
                answerExist = true;
                ans = Arrays.copyOf(match, match.length);
            }
                        
            return;
        }
        
        for(int i = start; i <= 10; i++){
            int targetToUse = info[i] + 1;            
            int amountToSpend = n >= targetToUse ? targetToUse : n;
            int gain = 0;
            
            n -= amountToSpend;
            match[i] += amountToSpend;
            
            if(info[i] < match[i]) gain = (10 - i);
            
            gainedScores += gain;
            
            comb(n, info, match, i + 1, gainedScores);
            
            n += amountToSpend;
            match[i] -= amountToSpend;
            gainedScores -= gain;
        }
    }   
}
