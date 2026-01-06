package 레벨3_문제;

public class 억억단을_외우자 {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] divisorsCount = new int[e + 1];
        int[] maxDivisorTarget = new int[e + 1];
        
        for(int i = 1; i <= e; i++){
            for(int j = i; j <= e; j += i){
                divisorsCount[j] += 1;
            }
        }
        
        int maxCount = divisorsCount[e];
        int maxNum = e; 
        maxDivisorTarget[e] = e;
            
        for(int i = e; i > 0; i--){
            if(divisorsCount[i] >= maxCount){
                maxNum = i;
                maxCount = divisorsCount[i];                
            }
            maxDivisorTarget[i] = maxNum;
        }
        
        for(int i = 0; i < starts.length; i++){
            int idx = starts[i];
            answer[i] = maxDivisorTarget[idx];
        }

        return answer;
    }    
}
