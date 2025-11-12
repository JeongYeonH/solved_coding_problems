package 레벨2_문제;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;        
        long min = 1;
        long max = limit;
        
        while(min <= max){
            long level = (min + max) / 2;
            long total_time = get_total_time(level, diffs, times);
            
            if(total_time <= limit){
                answer = (int) level;
                max = level - 1;
            }else if(total_time > limit){
                min = level + 1;
            }
        }
        
        return answer;
    }
    
    public long get_total_time(long level, int[] diffs, int[] times){
        long total_time = 0;
        
        for(int i = 0; i < diffs.length; i++){
            int diff = diffs[i];
            int time_curr = times[i];
            
            if(level >= diff){
                total_time += time_curr;
            }else{
                long repeat = diff - level;
                int used_time_to_solve = times[i - 1] + time_curr;
                total_time += repeat * used_time_to_solve + time_curr;               
            } 
            
            if (total_time > Long.MAX_VALUE / 2) break;
            
        }
        
        return total_time;
    }
}
