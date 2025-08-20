package 레벨3_문제;

import java.util.*;

public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a,b) -> a[1]-b[1]);      
        pQ.add(jobs[0]);
        
        int sec = 0;
        int idx = 1;
        while(list.size() < jobs.length){
            if(idx < jobs.length && jobs[idx][0] <= sec){   
                while(idx < jobs.length && jobs[idx][0] <= sec){
                    pQ.add(jobs[idx]);
                    idx++;
                }
            }
            if(!pQ.isEmpty()){
                int[] executable = pQ.peek();
                if(executable[0] <= sec){
                    sec += executable[1];
                    list.add(sec - executable[0]);
                    pQ.poll();                  
                }else{
                    sec = executable[0];
                }
            } else if (idx < jobs.length) {
                sec = jobs[idx][0]; 
            }  
        }
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        return sum/jobs.length;
    }
}
