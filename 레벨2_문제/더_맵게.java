package 레벨2_문제;

import java.util.PriorityQueue;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int sco : scoville){
            pq.offer(sco);
        }
        while(pq.peek() < K && pq.size() >= 2){
            int lowest = pq.poll();
            int nextLowest = pq.poll();
            int newSco = lowest + (nextLowest*2);
            pq.offer(newSco);
            answer++;
        }
        if(pq.peek() < K) return -1;
        return answer;
    }
}
