package 레벨2_문제;

import java.util.*;

public class 거리두기_확인하기 {
        
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int k = 0; k < places.length; k++){
            String[] place = places[k];
            
            boolean ok = true;
            outerLoop:
            for(int i = 0; i < place.length; i++){
                for(int j = 0; j < place[0].length(); j++){
                    String str = place[i].substring(j, j + 1);
                    
                    if(str.equals("P")){
                        boolean[][] visited = new boolean[place.length][place[0].length()];
                        if(!isDistance(visited, place, i, j)){
                            ok = false;
                            break outerLoop;
                        }
                    }
                }
                
            }
            answer[k] = ok ? 1 : 0; 
        }
        return answer;
    }
    
    public boolean isDistance (boolean[][] visited, String[] place, int y, int x){
        Queue<int[]> pQ = new LinkedList<>();
        
        int row = place.length;
        int col = place[0].length();
        
        int[] dy = new int[] {0 , 0, 1, -1};
        int[] dx = new int[] {1 , -1, 0, 0};
        
        pQ.add(new int[] {y, x});
        visited[y][x] = true;
        
        while(!pQ.isEmpty()){
            int size = pQ.size();
            for(int i = 0; i < size; i++){
                int[] curr = pQ.poll();
                visited[curr[0]][curr[1]] = true;

                for(int j = 0; j < 4; j++){
                    int newY = curr[0] + dy[j];
                    int newX = curr[1] + dx[j];

                    if(newY < 0 || newY >= row || newX < 0 || newX >= col) continue;
                    if(visited[newY][newX]) continue;
                                
                    int dist = Math.abs(newY - y) + Math.abs(newX - x); 
                    if(dist > 2) continue;
                    
                    String searchX = place[newY];
                    String search = searchX.substring(newX, newX + 1);
                                        
                    if(search.equals("X")) continue;
                    else if(search.equals("P")) return false;
                    else if(search.equals("O")){
                        visited[newY][newX] = true;
                        pQ.add(new int[] { newY, newX});
                    } 
                }
                
            }
        }        
        return true;
    }
}
