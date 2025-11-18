package 레벨3_문제;

public class 최적의_행렬_곱셈 {
    public int solution(int[][] matrix_sizes) {
        int length = matrix_sizes.length;
        int[][][] dp = new int[length][length][3];
        
        for(int i = 0; i < length; i++){
            dp[0][i] = new int[]{matrix_sizes[i][0], matrix_sizes[i][1], 0};
        }
        
        for(int i = 1; i < dp.length; i++){
            int currLine = i;
            
            for(int j = 0; j < dp.length - i; j++){
                int minMultiply = Integer.MAX_VALUE;
                
                for(int k = 0; k < currLine; k++){
                    int[] curr = multiply(dp[k][j], dp[currLine - k - 1][j + k + 1]);
                    
                    if(minMultiply > curr[2]){
                        minMultiply = curr[2];
                        dp[i][j] = curr;
                    }
                }
            }
        }
        
        return dp[length - 1][0][2];
    }
    
    public int[] multiply(int[] matrixA, int[] matrixB){
        int aRow = matrixA[0];
        int aCol = matrixA[1];
        int aSum = matrixA[2];
        
        int bCol = matrixB[1];
        int bSum = matrixB[2];
        
        return new int[] {aRow, bCol, (aRow * aCol * bCol) + aSum + bSum};
    }
}
