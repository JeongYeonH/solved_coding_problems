package 레벨3_문제;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 섬_연결하기 {
     public int solution(int n, int[][] costs) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();    
        int answer = 0;
        
        for(int[] edges : costs){
            int to = edges[0];
            int from = edges[1];
            int weigth = edges[2];
            
            graph.putIfAbsent(from, new HashMap<>());
            graph.putIfAbsent(to, new HashMap<>());
            
            graph.get(from).put(to, weigth);
            graph.get(to).put(from, weigth);
        }
        
        PriorityQueue<int[]> pQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));        
        boolean[] visited = new boolean[graph.size()];
        int startNode = costs[0][0];
        visited[startNode] = true;
        
        Map<Integer, Integer> adject = graph.get(startNode);
        for( int key : adject.keySet()){
            pQ.add(new int[] {key, adject.get(key)});
        }
        
        while(!pQ.isEmpty()){
            int[] lowest = pQ.poll();
            int lowestNode = lowest[0];
            if(visited[lowestNode]) continue;
            
            visited[lowestNode] = true;
            answer += lowest[1];
            
            Map<Integer, Integer> adjacent = graph.get(lowestNode);
            for( int key : adjacent.keySet()){
                pQ.add(new int[] {key, adjacent.get(key)});
            }

        }            
        return answer;
    }
}
