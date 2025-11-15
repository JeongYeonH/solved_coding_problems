package 레벨2_문제;

public class 혼자서_하는_틱텍토 {
    public int solution(String[] board) {
        int answer = -1;
        String[][] adjustedBoard = new String[3][3];
        
        for(int i = 0; i < 3; i++){
            adjustedBoard[i] = board[i].split("");
        }
        
        boolean _0isMatch = doesMatch(adjustedBoard, "O");
        boolean _XisMatch = doesMatch(adjustedBoard, "X");
        int count0 = countAllOfThem(adjustedBoard, "O");
        int countX = countAllOfThem(adjustedBoard, "X");
        
        if(countX > count0) return 0;
        if(count0 - countX > 1) return 0;
        
        if(_0isMatch && !_XisMatch){
            return (count0 == countX + 1) ? 1 : 0;
        }else if(!_0isMatch && _XisMatch){
            if(count0 == countX) return 1;
            else return 0;
        }else if(!_0isMatch && !_XisMatch){
            return 1;
        }else if(_0isMatch && _XisMatch){
            return 0;
        }
        
        return answer;
    }
    
    public boolean doesMatch(String[][] board, String type){
        for(int i = 0; i < 3; i++){
            if(board[i][0].equals(type) 
                && board[i][1].equals(type) 
                && board[i][2].equals(type)){
                return true;
            }
        }
        
        for(int i = 0; i < 3; i++){
            if(board[0][i].equals(type) 
                && board[1][i].equals(type) 
                && board[2][i].equals(type)){
                return true;
            }
        }
        
        if(board[0][0].equals(type) && board[1][1].equals(type) && board[2][2].equals(type))
            return true;

        if(board[0][2].equals(type) && board[1][1].equals(type) && board[2][0].equals(type))
            return true;
        
        return false;
    }
    
    public int countAllOfThem(String[][] board, String type){
        int count = 0;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j].equals(type)) count++;
            }
        }
        
        return count;
    }
}
