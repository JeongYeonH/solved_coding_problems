package 레벨2_문제;

import java.util.*;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        for(int a : priorities){
            pQ.add(a);
        }
        
        for(int i = 0; i < priorities.length; i++){
            q.add(new int[] {priorities[i], i});
        }
        
        int order = 0;
        while(!q.isEmpty()){
            int[] curr = q.peek();
            if(curr[0] != pQ.peek()){
                q.poll();
                q.add(curr);
            }else if(curr[0] == pQ.peek()){
                q.poll();
                pQ.poll();
                order++;
                if(curr[1] == location) return order;
            }
        }
        return answer;
    }
}
