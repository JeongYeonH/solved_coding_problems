package 레벨3_문제;

public class 선입_선출_스케줄링 {
    public int solution(int n, int[] cores) {                        
        if(n <= cores.length) return n;
        
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
            
        for(int core : cores){
            min = Math.min(min, core);
            max = Math.max(max, core);
        }
        
        max = max * n;
        long mid = 0;
        
        while(min <= max){
            mid = (min + max)/2;
            long servedJobs = numberOfJobsDone(mid, cores);
            
            if(servedJobs < n){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
            
        }
        
        long jobsBefore = 0;

        for(int i = 0; i < cores.length; i++){
            jobsBefore += (min - 1)/cores[i] + 1;
        }
        
        for(int i = 0; i < cores.length; i++){
            if(min%cores[i] == 0){
                jobsBefore++;
                if(jobsBefore == n) return i + 1;
            }
        }

        return -1;
    }
    
    public long numberOfJobsDone(long time, int[] cores){
        long jobs = 0;
        
        for(int i = 0; i < cores.length; i++){
            jobs += time/cores[i] + 1;
        }
        
        return jobs;
    }
}
