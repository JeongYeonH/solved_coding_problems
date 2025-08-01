package 레벨2_문제;

import java.util.*;

public class 무인도_여행 {
    public int[] solution(String[] maps) {
        List<Integer> arr = new ArrayList<>();
        String[][] newMaps = new String[maps.length][];
        for(int i = 0; i < maps.length; i++){
            newMaps[i] = maps[i].split("");
        }
        
        for(int i = 0; i < newMaps.length; i++){
            for(int j = 0; j < newMaps[i].length; j++){
                String str = newMaps[i][j];
                if(!str.equals("X") && !str.equals("F")){
                    int result = bfs(i, j, newMaps);
                    arr.add(result);
                }
            }
        }
        int[] ans = arr.stream().sorted().mapToInt(t -> t).toArray();
        return ans.length == 0 ? new int[] {-1} : ans;
    }
    
    public int bfs(int y, int x, String[][] newMaps){        
        Queue<int[]> q = new LinkedList<>();        
        q.add(new int[] {y , x});
        
        int[] dy = new int[] { -1, 1, 0, 0};
        int[] dx = new int[] {0, 0, -1, 1};
        int converage = 0;
        
        converage += Integer.parseInt(newMaps[y][x]);
        newMaps[y][x] = "F";
        
        while(!q.isEmpty()){            
            int[] curr = q.poll();
            
            for(int i = 0; i < 4; i++){
                int Y = curr[0] + dy[i];
                int X = curr[1] + dx[i];
                
                if(Y < 0 || Y >= newMaps.length || X < 0 || X >= newMaps[0].length) continue;
                if(!newMaps[Y][X].equals("X") && !newMaps[Y][X].equals("F")){
                    converage += Integer.parseInt(newMaps[Y][X]);
                    newMaps[Y][X] = "F";
                    q.add(new int[]{Y, X});
                }
            }
        }
        return converage;
    }
}
