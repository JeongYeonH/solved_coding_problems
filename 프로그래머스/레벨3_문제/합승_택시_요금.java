package 레벨3_문제;

import java.util.*;

public class 합승_택시_요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<int[]>> graph = new ArrayList<>(n+1);
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < fares.length; i++){
            int t = fares[i][0];
            int k = fares[i][1];
            int weight = fares[i][2];
            
            graph.get(t).add(new int[]{k, weight});
            graph.get(k).add(new int[]{t, weight});
        }
        
        int[] finalWeights = new int[n+1];
        int[] pointers = new int[] {s, a, b};
        
        for(int point : pointers){
            int[] weights = new int[n+1];
            Arrays.fill(weights, Integer.MAX_VALUE);
            dijkstra(graph, point, weights);
            
            for(int j = 1; j <= n; j++){
                if(weights[j] == Integer.MAX_VALUE){
                    finalWeights[j] = Integer.MAX_VALUE;
                }else{
                    finalWeights[j] += weights[j];
                }                
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 1; i < finalWeights.length; i++){
            answer = Math.min(answer, finalWeights[i]);
        }
        
        return answer;
    }
    
    public void dijkstra(List<List<int[]>> graph, int start, int[] weights){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});
        
        weights[start] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int noded = curr[0];
            int dist = curr[1];
            
            if(dist > weights[noded]) continue;
            
            List<int[]> adjacents = graph.get(curr[0]);
            
            for(int[] adjacent : adjacents){                
                int node = adjacent[0];
                int weight = adjacent[1];
                
                if(weights[node] <= weights[curr[0]] + weight) continue;
                
                weights[node] = weights[curr[0]] + weight;
                pq.add(new int[]{node, weights[node]});
            }        
        }
    }
}
