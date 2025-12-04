package 레벨1_문제;

public class 유연근무제 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int saturdayIdx = startday != 7 ? (6 - startday) : 6;  
        int sundayIdx = startday != 7 ? (6 - startday) + 1 : 0;
        
        for(int i = 0; i < timelogs.length; i++){
            boolean isNotLate = true;
            int right = schedules[i];
            int rightTime = 0;
            int hours = right / 100;
            int mins = right % 100;

            if(mins >= 50){
                rightTime += (hours + 1) * 100;
                rightTime += mins - 50;
            }else if( mins < 50){
                rightTime += right + 10;
            }

            
            
            for(int j = 0; j < 7; j++){
                int arriveTime = timelogs[i][j];
                
                if(j == saturdayIdx || j == sundayIdx) continue;
                
                if(rightTime < arriveTime){
                    isNotLate = false;
                    break;
                }
            }
            
            if(isNotLate) answer++;
        }
                
        return answer;
    }    
}
