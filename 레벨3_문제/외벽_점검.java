package 레벨3_문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 외벽_점검 {
    List<List<Integer>> list = new ArrayList<>();
    int length;
    int n;
    boolean[] visited;

    public int solution(int n, int[] weak, int[] dist) {
        this.length = dist.length;
        this.n = n;

        Arrays.sort(weak);
        visited = new boolean[dist.length];
        getComb(dist, new ArrayList<>());
        
        int numOfCovers = length+1;
        for(int i = 0; i < list.size(); i++){
            List<Integer> order = list.get(i);       
            int minCover = canCover(order, weak);
            if(minCover < numOfCovers) numOfCovers = minCover;
                        
        }
        
        return numOfCovers > length ? -1 : numOfCovers;
    }
    
    public void getComb(int[] dist, List<Integer> cases) {
        if (cases.size() == length) {
            list.add(new ArrayList<>(cases)); 
            return;
        }
        for (int i = 0; i < dist.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            cases.add(dist[i]);
            getComb(dist, cases);
            cases.remove(cases.size() - 1);
            visited[i] = false;
        }
    }
    
    public int canCover(List<Integer> order, int[] weak){
        int minNum = order.size() + 1;
        int[] weakDouble = new int[weak.length*2];
        for(int i=0; i < weakDouble.length; i++){
            weakDouble[i] = i < weak.length ? weak[i] : weak[i - weak.length] + n;
        }
        
        for(int startPos : weak){
            int coveredPoint = 0;
            int beginRange = startPos;
            int goneRange = beginRange;
            int lastCoverIdx = 0; 
            
            int startIdx = -1;
            for (int i = 0; i < weakDouble.length; i++) {
                if (weakDouble[i] == startPos) {
                    startIdx = i;
                    break;
                }
            }
            
            checkRange:
            for(int i=0; i < order.size(); i++){
                goneRange = beginRange + order.get(i);
            
                for(int j = startIdx; j < weakDouble.length; j++){
                    int spot = weakDouble[j];
                    if( beginRange <= spot && spot <= goneRange){
                        coveredPoint++;
                        lastCoverIdx = j;
                        if(coveredPoint == weak.length){
                            if(i+1 < minNum) minNum = i+1;
                            break checkRange;
                        } 
                        if(lastCoverIdx == weakDouble.length-1) break checkRange;
                    }                    
                }
                beginRange = weakDouble[lastCoverIdx + 1];
            }
        }
        
        return minNum;
    }
}
