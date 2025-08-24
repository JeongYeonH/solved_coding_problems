package 백준.골드._3;

import java.util.*;
import java.io.*;

public class 레이저_통신 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("백준/골드/_3/레이저_통신.txt"));

        String line;
        
        int row = 0;
        int col = 0;
        
        String[] size = br.readLine().split(" ");
        col = Integer.parseInt(size[0]);
        row = Integer.parseInt(size[1]);

        List<char[]> box = new ArrayList<>();
        List<int[]> cPoints = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            line = br.readLine();
            char[] L = line.toCharArray();
            box.add(L);

            for (int j = 0; j < col; j++) {
                if (L[j] == 'C') {
                    cPoints.add(new int[]{i, j});
                }
            }
        }
        br.close();

        int[] startPoint = cPoints.get(0);
        int[] endPoint = cPoints.get(1);

        int[][][] infoBox = new int[row][col][4];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Arrays.fill(infoBox[i][j], -1);
            }
        }
        
        bfs(box, infoBox, startPoint);
        
        int[] target = infoBox[endPoint[0]][endPoint[1]];
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < target.length; i++) {
            if (target[i] == -1) continue;
            answer = Math.min(answer, target[i]);
        }

        System.out.println(answer);
    }

    public static void bfs(List<char[]> box, int[][][] infoBox, int[] startPoint) {
        Deque<int[]> dq = new LinkedList<>();

        int row = box.size();
        int col = box.get(0).length;
        
        int[] dy = new int[] {-1, 1, 0, 0}; 
        int[] dx = new int[] {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int y = startPoint[0] + dy[i];
            int x = startPoint[1] + dx[i];

            if (y < 0 || y >= row || x < 0 || x >= col || box.get(y)[x] == '*') continue;
            
            infoBox[y][x][i] = 0; 
            dq.addFirst(new int[]{y, x, i}); 
        }

        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int currY = curr[0];
            int currX = curr[1];
            int currDir = curr[2];
            
            for (int i = 0; i < 4; i++) {
                int nextY = currY + dy[i];
                int nextX = currX + dx[i]; 

                if (nextY < 0 || nextY >= row || nextX < 0 || nextX >= col || box.get(nextY)[nextX] == '*') continue;

                int newMirrors = infoBox[currY][currX][currDir];
                if (currDir != i) {
                    newMirrors++;
                }

                if (infoBox[nextY][nextX][i] == -1 || infoBox[nextY][nextX][i] > newMirrors) {
                    infoBox[nextY][nextX][i] = newMirrors;

                    if (currDir == i) {
                        dq.addFirst(new int[]{nextY, nextX, i});
                    } else {
                        dq.addLast(new int[]{nextY, nextX, i});
                    }
                }
            } 
        }
    }
}
