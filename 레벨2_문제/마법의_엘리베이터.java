package 레벨2_문제;

public class 마법의_엘리베이터 {
    public int solution(int storey) {
        int count = 0;
        
        while(storey > 0){
            int n = storey%10;
            storey /= 10;
            
            if(n < 5){
                count += n;
            }else if(n > 5){
                count += 10 - n;
                storey++;
            }else if(n==5){
                count += 5;
                if(storey%10 >= 5) storey++;
            }
        }
        
        return count;
    } 
}
