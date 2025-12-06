package 레벨1_문제;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int row = park.length;
        int col = park[0].length;        
        int[][] size = new int[row][col];
        int maxSize = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if (park[i][j].equals("-1")) {
                    if (i == 0 || j == 0) {
                        size[i][j] = 1;
                    } else {
                        int up = size[i - 1][j];
                        int left = size[i][j - 1];
                        int diag = size[i - 1][j - 1];

                        size[i][j] = Math.min(up, Math.min(left, diag)) + 1;
                    }
                    maxSize = Math.max(maxSize, size[i][j]);
                }
            }
        }
        
        for(int i = 0; i < mats.length; i++){
            int mat = mats[i];
            
            if(mat <= maxSize){
                answer = Math.max(mat, answer);
            }
        }
        
        return answer;
    }    
}
