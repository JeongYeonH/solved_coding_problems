package 레벨2_문제;

import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        String[][] bd = new String[m][n];
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < m; i++){
            String[] row = board[i].split("");
            bd[i] = row;
        }
        
        while(true){
            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    String pivot = bd[i][j];
                    String right = bd[i][j + 1];
                    String down = bd[i + 1][j];
                    String downRight = bd[i + 1][j + 1];

                    if(pivot.equals(right) && 
                    pivot.equals(down) && 
                    pivot.equals(downRight) && 
                    !pivot.equals("0")){
                        list.add(new int[]{i, j});
                    }
                }
            }
            
            if(list.size() == 0) break;

            for(int i = 0; i < list.size(); i++){
                int[] coordinate = list.get(i);

                int y = coordinate[0];
                int x = coordinate[1];
                
                if(!bd[y][x].equals("0")){
                    bd[y][x] = "0"; 
                    answer++; 
                }                 
                
                if(!bd[y][x + 1].equals("0")){
                    bd[y][x + 1] = "0"; 
                    answer++;
                }                 
                
                if(!bd[y + 1][x].equals("0")){
                    bd[y + 1][x] = "0"; 
                    answer++;
                }                 
                
                if(!bd[y + 1][x + 1].equals("0")){
                    bd[y + 1][x + 1] = "0"; 
                    answer++; 
                } 
            }
            
            list.clear();
            
            for(int i = m - 1; i >= 0 ; i--){
                for(int j = 0; j < n ; j++){
                    String target = bd[i][j];
                    int yPos = i;

                    if(target.equals("0")){
                        if(yPos <= 0) continue;

                        while(bd[yPos][j].equals("0")){
                            yPos--;
                            if(yPos <= 0) break;
                        }

                        bd[i][j] = bd[yPos][j];
                        bd[yPos][j] = "0";
                    }
                }
            }
        }
            
        return answer;
    }
}
