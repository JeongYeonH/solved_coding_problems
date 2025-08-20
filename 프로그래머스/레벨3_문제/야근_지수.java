package 레벨3_문제;

import java.util.Arrays;

public class 야근_지수 {
     public long solution(int n, int[] works) {      
        if(works.length == 0){
            int finalAmount = (works[0] - n) >= 0 ? (works[0]-n) : 0;
            return (long) Math.pow(finalAmount, 2);
        }
        
        Arrays.sort(works);
        int [] reversedWorks = new int[works.length];
        for(int i = 0; i < works.length; i++){
            reversedWorks[i] = works[works.length-1 - i];
        }
        int currIdx = 0;
        
        outer:
        while(n > 0){      
            int currValue = reversedWorks[currIdx];
            while(reversedWorks[currIdx] == currValue && n > 0){             
                if (n == 0) break;    
                if (reversedWorks[currIdx] == 0) break outer;
                reversedWorks[currIdx] -=1;
                n--; 
                currIdx++;
                if(currIdx == reversedWorks.length -1){
                    if( n > 0){
                        reversedWorks[currIdx] -=1;
                        n--;
                        break;
                    }else if( n == 0) break;
                }                  
            }          
            currIdx = 0;
        }
        
        long answer = 0;
        for(int work : reversedWorks){
            answer += Math.pow(work, 2);
        }
        return answer;
    }   
}
