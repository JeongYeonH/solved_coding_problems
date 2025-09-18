package 레벨3_문제;

public class 보행자_천국 {
    public int solution(int m, int n, int[][] cityMap) {  
        int[][][] possibleMap = new int[m][n][2];
        possibleMap[0][0] = new int[]{1, 1};
        
        for(int i = 1; i < n; i++){
            if(cityMap[0][i] == 1) break;
            possibleMap[0][i][1] = possibleMap[0][i - 1][1];
        }
        
        for(int i = 1; i < m; i++){
            if(cityMap[i][0] == 1) break;
            possibleMap[i][0][0] = possibleMap[i - 1][0][0];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int fromUp = 0;
                int fromLeft = 0;
                
                if(cityMap[i - 1][j] == 2) fromUp = possibleMap[i - 1][j][0];
                else if(cityMap[i - 1][j] == 1) fromUp = 0;
                else fromUp += possibleMap[i - 1][j][0] + possibleMap[i - 1][j][1];

                if(cityMap[i][j - 1] == 2) fromLeft = possibleMap[i][j - 1][1];
                else if(cityMap[i][j - 1] == 1) fromLeft = 0;
                else fromLeft += possibleMap[i][j - 1][0] + possibleMap[i][j - 1][1];
                
                possibleMap[i][j][0] += fromUp; 
                possibleMap[i][j][0] = possibleMap[i][j][0]%20170805;
                
                possibleMap[i][j][1] += fromLeft;
                possibleMap[i][j][1] = possibleMap[i][j][1]%20170805;
    
            }
        }
        
        int[] endPoint = possibleMap[m - 1][n - 1];
        
        return (endPoint[0] + endPoint[1])%20170805;
    }
}
