package 레벨2_문제;

import java.util.*;

public class 리코쳇_로봇 {
    public int solution(String[] board) {
        String[][] modifiedBoard = new String[board.length][];
        int startY = 0; int startX = 0;
        int endY = 0; int endX = 0;
        
        for(int i = 0; i < board.length; i++){
            modifiedBoard[i] = board[i].split("");
            for(int j = 0; j < modifiedBoard[i].length; j++){
                if(modifiedBoard[i][j].equals("R")){
                    startY = i;
                    startX = j;      
                }else if(modifiedBoard[i][j].equals("G")){
                    endY = i;
                    endX = j;
                }
            }
        }
        bfs(startY, startX, modifiedBoard);
        String value = modifiedBoard[endY][endX];
        
        if(value.equals("G")) return -1;        
        return Integer.parseInt(value);
    }
    
    public void bfs(int y, int x, String[][] modifiedBoard){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        
        int[] dirY = new int[] {0, 0, -1, 1};
        int[] dirX = new int[] {-1, 1, 0, 0};
        int depth = 1;
        
        while(!q.isEmpty()){
            int size = q.size();       
            for(int j = 0; j < size; j++){
                int[] curr = q.poll();
                
                for(int i = 0; i < 4; i++){
                    int[] candidate = new int[] {curr[0], curr[1]};
                    while(true){
                        candidate[0] += dirY[i];
                        candidate[1] += dirX[i];
                        if(candidate[0] < 0 || candidate[0] >= modifiedBoard.length ||
                            candidate[1] < 0 || candidate[1] >= modifiedBoard[0].length){
                            candidate[0] -= dirY[i];
                            candidate[1] -= dirX[i];
                            break;
                        }
                        String val = modifiedBoard[candidate[0]][candidate[1]];
                        if(val.equals("D")){
                            candidate[0] -= dirY[i];
                            candidate[1] -= dirX[i];
                            break;
                        }
                    }
                    
                    String val = modifiedBoard[candidate[0]][candidate[1]];
                    if(candidate[0] == curr[0] && candidate[1] == curr[1]) continue;
                    
                    if(val.equals(".") || val.equals("G")){
                        modifiedBoard[candidate[0]][candidate[1]] = Integer.toString(depth);
                        q.add(candidate);
                    }else if(val.matches("\\d+")){
                        int dep = Integer.parseInt(val);
                        if(depth < dep){
                            q.add(candidate);
                        }
                    }                 
                }
            }
            depth++;
        }
    }
}
