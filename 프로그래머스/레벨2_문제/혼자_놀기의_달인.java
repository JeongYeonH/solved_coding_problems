package 레벨2_문제;

import java.util.PriorityQueue;

public class 혼자_놀기의_달인 {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i = 0; i < cards.length; i++){
            if(visited[i]) continue;
            
            int amount = dfs(cards, 0, i, visited);
            pQ.add(amount);
        }
        
        int first = pQ.poll();
        
        if(pQ.isEmpty()) return 0;
        
        return first * pQ.poll();
    }
    
    public int dfs(int[] cards, int depth, int index, boolean[] visited){
        if(visited[index]) return depth;
        
        visited[index] = true;
        int nextIndex = cards[index];
        depth++;
        
        return dfs(cards, depth, nextIndex - 1, visited);
    }   
}
