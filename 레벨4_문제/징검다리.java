package 레벨4_문제;

import java.util.*;

public class 징검다리 {
    int n;
    public int solution(int distance, int[] rocks, int n) {
        List<Integer> points = new ArrayList<>();
        points.add(0);
        for(int rock : rocks) points.add(rock);
        points.add(distance);
        Collections.sort(points);
        
        this.n = n;
        
        int low = 0;
        int high = distance;
        int answer = 0;
        
        while(low <= high){
            int mid = (low + high)/2;
            if(isAble(points, distance, mid)){
                answer = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return answer;
    }
    
    public boolean isAble(List<Integer> points, int distance, int candidateDis){
        int removeStone = 0;
        int prev = points.get(0);
        
        for(int i = 1; i < points.size(); i++){
            int curr = points.get(i);
            if(curr - prev < candidateDis){
                removeStone++;
                if(removeStone > n) return false;
            }else{
                prev = curr;
            }
        }
        
        return true;
    }
}
