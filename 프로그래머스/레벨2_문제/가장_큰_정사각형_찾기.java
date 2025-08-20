package 레벨2_문제;

public class 가장_큰_정사각형_찾기 {
    public int solution(int [][]board){
        int answer = 0;
        if(board.length == 1 && board[0].length == 1) return board[0][0];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1) answer = 1;  
            }
        }
        
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j < board[i].length; j++){
                if(board[i][j] == 1){
                    int candidate = Math.min(Math.min(board[i-1][j], board[i-1][j-1]), board[i][j-1]);
                    if(candidate != 0){
                        int act = (int) Math.pow(Math.sqrt(candidate)+1, 2);
                        answer = Math.max(act, answer);
                        board[i][j] = act;
                    }
                }
            }
        }
        return answer;
    }
}
