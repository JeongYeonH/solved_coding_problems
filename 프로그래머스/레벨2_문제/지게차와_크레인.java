package 레벨2_문제;

import java.util.*;

public class 지게차와_크레인 {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int row = storage.length;
        int col = storage[0].length();
        String[][] coor = new String[row][col];
        int[][] approach = new int[row][col];
        
        for(int i = 0; i < col; i++){
            approach[0][i] = 1;
            approach[row - 1][i] = 1;
        }
        
        for(int i = 0; i < row; i++){
            String[] str = storage[i].split("");
            
            coor[i] = str;
            approach[i][0] = 1;
            approach[i][col - 1] = 1;
        }
        
        for(int i = 0; i < requests.length; i++){
            String request = requests[i];
            
            if(request.length() == 1){
                brute_force_edge(coor, approach, request);
                bfs_range(coor, approach, request);
            }else{
                brute_force_any(coor, request.substring(0, 1));
                bfs_range(coor, approach, request.substring(1, 2));
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!coor[i][j].equals("0")) answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs_range(String[][] coor, int[][] approach, String target){
        int row = coor.length;
        int col = coor[0].length;
    
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(approach[i][j] == 1 && coor[i][j].equals("0")){
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        int[] dy = new int[] {0, 0, -1, 1};
        int[] dx = new int[] {-1, 1, 0, 0};
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            
            for(int i = 0; i < 4; i++){
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                
                if(0 > nextY || nextY >= row || 0 > nextX || nextX >= col) continue;
                
                approach[nextY][nextX] = 1;

                if(coor[nextY][nextX].equals("0") && !visited[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    q.add(new int[] {nextY, nextX});
                }
            }
        }
    }         
    
    
    public void brute_force_any(String[][] coor, String target){
        int row = coor.length;
        int col = coor[0].length;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(coor[i][j].equals(target)){
                    coor[i][j] = "0";
                }
            }
        }
    }
    
    public void brute_force_edge(String[][] coor, int[][] approach, String target){
        int row = coor.length;
        int col = coor[0].length;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(coor[i][j].equals(target) && approach[i][j] == 1){
                    coor[i][j] = "0";
                }
            }
        }
    }
}
