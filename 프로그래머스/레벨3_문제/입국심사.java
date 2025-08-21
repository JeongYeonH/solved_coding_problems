package 레벨3_문제;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 0;
        long tempRight = 0;
        
        for(int i = 0; i < times.length; i++){
            tempRight = Math.max(tempRight, times[i]);
        }
        
        long right = (long) tempRight * (long) n;
        
        while(left <= right){
            long mid = (left + right)/2;
            long numOfPassengers = passengers(n, times, mid);
            
            if(numOfPassengers >= n){
                right = mid - 1;
                answer = mid;
            }else{
                left = mid + 1;
            }           
        }
                
        return answer;
    }
    
    public long passengers (int n, int[] times, long targetTime){
        long num = 0;
        for(int i = 0; i < times.length; i++){
            long time = times[i];
            
            if(targetTime < time) break;
            num += targetTime/time;
        }
        
        return num;
    }
}
