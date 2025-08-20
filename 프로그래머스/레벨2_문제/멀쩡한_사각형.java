package 레벨2_문제;

public class 멀쩡한_사각형 {
     public long solution(int w, int h) {        
        long answer = 0;
        
        int gcd = gcd(w,h);
        int W = w / gcd;
        int H = h / gcd;
        long priorY = 0;

        double ratio = (double) H / W; 
        for(int i = 1; i <= W; i++) {
            double y = ratio * i;
            long currCeil = (long) Math.ceil(y);
            answer += currCeil - priorY;
            priorY = (long) Math.floor(y);
        }

        answer = (long) w * h - answer * (w / W);
        return answer;
    }

    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
