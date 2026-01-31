package 레벨1_문제;

public class 택배_상자_꺼내기 {
    public int solution(int n, int w, int num) {
        int[][] building = new int[n/w + 1][w];
        boolean isRight = true;
        
        int currLevel = 0;
        int currCol = 0;
        
        int startY = 0;
        int startX = 0;
        
        for(int i = 1; i <= n; i++){
            building[currLevel][currCol] = i;
            if(i == num){
                startY = currLevel;
                startX = currCol;
            }
            
            if(isRight){         
                currCol++;
                if(currCol == w){
                    isRight = false;
                    currLevel++;
                    currCol--;
                } 
            }else{
                currCol--;
                if(currCol == -1){
                    isRight = true;
                    currLevel++;
                    currCol++;
                }
            }
        }
        
        int answer = 0;
        for(int i = startY; i <= n/w; i++){
            if(building[i][startX] != 0){
                answer++;
            }
        }
        
        return answer;
    }   
}
