package 레벨2_문제;

public class 점_찍기 {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i = 0; i <= d; i +=k){
            double yPow = Math.pow(d, 2) - Math.pow(i, 2);
            double y = Math.sqrt(yPow);
            double yfl = (int) Math.floor(y/k);            
            answer += yfl + 1;
        }
       
        return answer;
    }
}
