package 레벨2_문제;

import java.util.*;

public class 두_큐_합_같게_만들기 {
    public int solution(int[] queue1, int[] queue2) {

        long q1Sum = Arrays.stream(queue1).sum();    
        long q2Sum = Arrays.stream(queue2).sum();
        Queue<Integer> q1Q = new LinkedList<>();
        Queue<Integer> q2Q = new LinkedList<>();
        Arrays.stream(queue1).forEach(a -> q1Q.offer(a));
        Arrays.stream(queue2).forEach(b -> q2Q.offer(b));
        
        int turn = 0;
        while(q1Sum != q2Sum && turn < queue1.length*3){
            if(q1Sum > q2Sum){
                int val1 = q1Q.poll();
                q2Q.add(val1);
                q2Sum += val1;
                q1Sum -= val1;
                
            }else if(q2Sum > q1Sum){
                int val2 = q2Q.poll();
                q1Q.add(val2);
                q1Sum += val2;
                q2Sum -= val2;           
            }
            
            turn++;
        }

        return turn >= queue1.length*3 ? -1 : turn;
    }
}
