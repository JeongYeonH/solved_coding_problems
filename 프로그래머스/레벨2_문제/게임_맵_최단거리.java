package 레벨2_문제;

import java.util.*;

public class 게임_맵_최단거리 {
    int[][] maps;
    int xLength;
    int yLength;
    public int solution(int[][] maps) {
        yLength = maps.length;
        xLength = maps[0].length;
        int[][] dijkstra = new int[yLength][xLength];
        for (int i = 0; i < dijkstra.length; i++) {
            Arrays.fill(dijkstra[i], yLength*xLength+1);
        }
        
        this.maps = maps;
        bfs(dijkstra);
        
        int val = dijkstra[yLength-1][xLength-1]+1;
        if(val == yLength*xLength+2) return -1;        
        return val;
    }
    
    public void bfs(int[][] dijkstra){        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0});
        dijkstra[0][0] = 0;
        
        
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0 , 0, -1, 1};
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            int y = curr[0];
            int x = curr[1];
            
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if( 0 <= ny && ny < yLength && 0 <= nx && nx < xLength){
                    if(maps[ny][nx] == 1 && dijkstra[ny][nx] > dijkstra[y][x] + 1){
                        dijkstra[ny][nx] = dijkstra[y][x] + 1;
                        q.add(new int[] {ny, nx});
                    }
                }
            }
        } 
    }
}
