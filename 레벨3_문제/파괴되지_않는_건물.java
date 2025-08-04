package 레벨3_문제;

public class 파괴되지_않는_건물 {
    public int solution(int[][] board, int[][] skill) {    
        int row = board.length;
        int col = board[0].length;
        int[][] zeroBoard = new int[row][col];
        int answer = row*col;
        
        for(int[] sk : skill){
            int type = sk[0];
            int degree = sk[5];
            int startY = sk[1]; int startX = sk[2];
            int endY = sk[3]+1; int endX = sk[4]+1;
            if(type == 1){
                zeroBoard[startY][startX] -= degree;
                if(endY < row){
                    zeroBoard[endY][startX] += degree;
                }
                if(endX < col){
                    zeroBoard[startY][endX] += degree;
                }
                if(endX < col && endY < row){
                    zeroBoard[endY][endX] -= degree;
                }
                
            }else if(type == 2){
                zeroBoard[startY][startX] += degree;
                if(endY < row){
                    zeroBoard[endY][startX] -= degree;
                }
                if(endX < col){
                    zeroBoard[startY][endX] -= degree;
                }
                if(endX < col && endY < row){
                    zeroBoard[endY][endX] += degree;
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int previousX = j-1 >= 0 ? zeroBoard[i][j-1] : 0;               
                zeroBoard[i][j] = zeroBoard[i][j] + previousX;
                
            }
            for(int j = 0; j < col; j++){
                int previousY = i-1 >= 0 ? zeroBoard[i-1][j] : 0;
                zeroBoard[i][j] = zeroBoard[i][j] + previousY;
                board[i][j] += zeroBoard[i][j];
                if(board[i][j] < 1){
                    answer--;
                }
            }
        }
        return answer;
    }
}

