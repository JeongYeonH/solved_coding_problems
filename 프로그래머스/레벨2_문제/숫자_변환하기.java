package 레벨2_문제;

import java.util.*;

public class 숫자_변환하기 {
    int y;
    int minDepth = 1000001;
    public int solution(int x, int y, int n) {
        this.y = y;
        bfs(x, n);
        
        return minDepth == 1000001 ? -1 : minDepth;
    }
    
    public void bfs (int x, int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[y+1];        
        int[] arr = new int[] {2, 3};
        int depth = 0;
        q.add(x);
        
        while(!q.isEmpty()){
            int size = q.size();            
            for(int i = 0; i < size; i++){
                
                int curr = q.poll();
                if(curr == y){
                    minDepth = Math.min(minDepth, depth);
                    break;
                }
                
                for(int j = 0; j < 3; j++){
                    int newCurr;
                    if(j<2){
                        newCurr = curr*arr[j];
                    }else{
                        newCurr = curr + n;
                    }
                    if(newCurr > y || visited[newCurr]) continue;
                    q.add(newCurr);
                    visited[newCurr] = true;
                }
            }
            depth++;
        }
    }
}
