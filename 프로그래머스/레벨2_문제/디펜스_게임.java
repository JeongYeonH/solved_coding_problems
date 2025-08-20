package 레벨2_문제;

import java.util.PriorityQueue;

public class 디펜스_게임 {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < enemy.length; i++){
            pQ.add(enemy[i]);
            n -= enemy[i];
            
            if( n < 0){
                if(k > 0){
                    n += pQ.poll();
                    k--;
                }else{
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}
