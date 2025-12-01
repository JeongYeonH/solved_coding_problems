package 레벨1_문제;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        String pivotColor = board[h][w];
        
        int[] dy = new int[] { -1, 1, 0, 0};
        int[] dx = new int[] { 0, 0, -1, 1};
        
        for(int i = 0; i < dy.length; i++){
            int y = h + dy[i];
            int x = w + dx[i];
            
            if(y < 0 || y >= row || x < 0 || x >= col) continue;
            
            String color = board[y][x];
            
            if(color.equals(pivotColor)) answer++;
        }
        
        return answer;
    }    
}
