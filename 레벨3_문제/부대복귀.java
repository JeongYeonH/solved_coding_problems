package 레벨3_문제;

import java.util.*;

public class 부대복귀 {
List<List<Integer>> graph = new ArrayList<>();
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {    
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        

        int[] nodes = new int[n+1];
        Arrays.fill(nodes, 100001);
        dijkstra(destination, nodes);
        
        int[] ans = Arrays.stream(sources).map(t -> nodes[t] == 100001 ? -1 : nodes[t]).toArray();
        return ans;
    }
    
    public void dijkstra(int startNode, int[] nodes){
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        nodes[startNode] = 0;
        int distance = 0;
        
        while(!q.isEmpty()){ 
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curr = q.poll();
                for(int neighbor : graph.get(curr)){
                    if(nodes[neighbor] > distance + 1){
                        nodes[neighbor] = distance + 1;
                        q.add(neighbor);
                    }
                }
            }
            distance++;            
        }
    }
}
