package 백준.골드._3;

import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class 레이저_통신 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("백준/골드/_3/레이저_통신.txt"));

        String line;
        int lineIdx = 0;
        

        int[] startPoint = new int[2];

        List<String[]> box = new ArrayList<>();
        List<int[][]> infoBox = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            if(lineIdx != 0){
                String[] L = line.split("");
                box.add(L);

                int[][] newMinus = new int[L.length][4];
                infoBox.add(newMinus); 

                for(int i = 0; i < L.length; i++){
                    String st = L[i];
                    //System.out.print(st);
                    if(st.equals("C")){
                        //System.out.print("만족");
                        startPoint[0] = lineIdx - 1;
                        startPoint[1] = i;
                        //infoBox.get(lineIdx - 1)[i] = 
                    }
                }
            }

            lineIdx++;
        }
        br.close();

        bfs(box, infoBox, startPoint[0], startPoint[1]);

        for(String[] b : box){
            System.out.println(Arrays.toString(b));
        }
        for(int[][] ib : infoBox){
            for(int i = 0; i < ib.length; i++){
                System.out.print(Arrays.toString(ib[i]));
            }
            System.out.println("");
        }
        //System.out.println(Arrays.toString(startPoint));
    }

    public static void bfs(List<String[]> box, List<int[][]> infoBox, int stY, int stX){
        Queue<int[]> q = new LinkedList<>();

        int row = box.size();
        int col = box.get(0).length;

        boolean[][] visited = new boolean[row][col];
        
        q.add(new int[] {stY, stX});
        infoBox.get(stY)[stX] = new int[] {1, 1, 1, 1};

        int[] dy = new int[] {1, -1, 0, 0};
        int[] dx = new int[] {0, 0, -1, 1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            for(int i = 0; i < 4; i++){
                int y = curr[0] + dy[i];
                int x = curr[1] + dx[i];
                
                if(y < 0 || y >= row || x < 0 || x >= col) continue;
                if(visited[y][x] == true) continue;
                
                visited[y][x] = true;
            }   
        }
    }
}
