package 레벨3_문제;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        for(int[] puddle : puddles){
            int x = puddle[0];
            int y = puddle[1];
            map[y-1][x-1] = -1;
        }
        map[0][0] = 1;
        for(int i = 0; i < m; i++){
            if(map[0][i] == -1) break;
            map[0][i] = 1;
            
        }
        for(int i = 0; i < n; i++){
            if(map[i][0] == -1) break;
            map[i][0] = 1;
            
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(map[i][j] == -1) continue;
                int preY = map[i-1][j] != -1 ? map[i-1][j] : 0;
                int preX = map[i][j-1] != -1 ? map[i][j-1] : 0;
                map[i][j] = (preY+preX)%1000000007;
            }
        }

        return map[n-1][m-1];        
    }
}
