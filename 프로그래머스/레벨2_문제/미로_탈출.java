package 레벨2_문제;

import java.util.PriorityQueue;

public class 미로_탈출 {
    public int solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();
        
        int[][] VMap = new int[row][col];
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        
        int[] start = new int[2];
        int[] arrive = new int[2];
        
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                String str = maps[i].substring(j, j + 1);
                VMap[i][j] = Integer.MAX_VALUE;
                
                if(str.equals("L")){
                    pQ.add(new int[]{i, j, 0});
                }else if(str.equals("S")){
                    start[0] = i;
                    start[1] = j;
                }else if(str.equals("E")){
                    arrive[0] = i;
                    arrive[1] = j;
                }
                
            }
        }
        
        while(!pQ.isEmpty()){
            int[] curr = pQ.poll();
            int currY = curr[0];
            int currX = curr[1];
            int currVal = curr[2];
            
            for(int i = 0; i < 4; i++){
                int y = currY + dy[i];
                int x = currX + dx[i];
                
                if(y < 0 || y >= row || x < 0 || x >= col) continue;
                if(maps[y].substring(x, x + 1).equals("X")) continue;
                if(VMap[y][x] <= currVal + 1) continue;
                
                VMap[y][x] = currVal + 1;
                pQ.add(new int[]{y, x, currVal + 1});
                
            }
        }

        int arriveStart = VMap[start[0]][start[1]];
        int arriveEnd = VMap[arrive[0]][arrive[1]];
        
        if(arriveStart >= Integer.MAX_VALUE || arriveEnd >= Integer.MAX_VALUE) return -1;
        
        return arriveStart + arriveEnd;
    }   
}
