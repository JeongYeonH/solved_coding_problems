package 레벨2_문제;

import java.util.*;

class Solution{
    public int solution(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        int[] Xpivots = new int[land[0].length];
        
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(!visited[i][j] && land[i][j] == 1){
                    int[] info = bfs(land, visited, i, j);
                    
                    int right = info[0];
                    int left = info[1];
                    int amount = info[2];
                    
                    for(int k = left; k <= right; k++){
                        Xpivots[k] += amount;
                    }
                }
            }            
        }
        
        int answer = 0;
        
        for(int i = 0; i < Xpivots.length; i++){
            answer = Math.max(answer, Xpivots[i]);
        }
        
        return answer;
    }
    
    public int[] bfs(int[][] land, boolean[][] visited, int y, int x){
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{y, x});
        visited[y][x] = true;
        
        int amount = 1;
        int left = x;
        int right = x;
        
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currY = curr[0];
            int currX = curr[1];
            
            for(int i = 0; i < 4; i++){
                int newY = currY + dy[i];
                int newX = currX + dx[i];
                
                if(newY < 0 || newY >= land.length 
                    || newX < 0 || newX >= land[0].length) continue;
                if(visited[newY][newX]) continue;
                if(land[newY][newX] == 0) continue;
                
                visited[newY][newX] = true;
                amount++;
                
                left = Math.min(left, newX);
                right = Math.max(right, newX);
                
                q.add(new int[]{newY, newX});                
            }
            
        }
        
        return new int[]{right, left, amount};
    }    
}
