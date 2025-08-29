package 레벨3_문제;

import java.util.PriorityQueue;

public class 경주로_건설 {
    public int solution(int[][] board) {
               
        int row = board.length;
        int col = board[0].length;
        
        int[][][] boardInfo = new int[row][col][4];
        
        bfs(board, boardInfo, row, col);
        
        int answer = Integer.MAX_VALUE;
        int[] lastBlock = boardInfo[row - 1][col - 1];
        for(int i = 0; i < 4; i++){
            int k = lastBlock[i];
            
            if(k == 0) continue;
            answer = Math.min(answer, k);
        }
        
        return answer;
    }
    
    public void bfs(int[][] board, int[][][] boardInfo, int row, int col){
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[3] - b[3]);
        q.add(new int[]{0, 0, 1, 0});
        q.add(new int[]{0, 0, 3, 0});
        
        int[] dy = new int[] {-1, 1, 0, 0};
        int[] dx = new int[] {0, 0, -1, 1};
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            int currY = curr[0];
            int currX = curr[1];
            int currDir = curr[2];
            int currPrice = curr[3];
            
            for(int i = 0; i < 4; i++){
                int y = currY + dy[i];
                int x = currX + dx[i];
                int dir = i;
                int price;
                
                if(y < 0 || y >= row || x < 0 || x >= col || board[y][x] == 1) continue;
                
                if(currDir == dir){
                    price = currPrice + 100;
                }else{
                    price = currPrice + 600;
                }
                
                if(boardInfo[y][x][dir] >= price || boardInfo[y][x][dir] == 0 ){
                    boardInfo[y][x][dir] = price;                    
                }else{
                    continue;
                } 
                
                q.add(new int[] {y, x, dir, price});                                
            }
        }
    }
}
