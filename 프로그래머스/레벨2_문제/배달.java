package 레벨2_문제;

import java.util.*;

public class 배달 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<List<Integer>> pathGraph = new ArrayList<>();
        List<List<Integer>> weightGraph = new ArrayList<>();        
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for(int i = 0; i <= N; i++){
            pathGraph.add(new ArrayList<>());
            weightGraph.add(new ArrayList<>());
        }
        
        for(int[] path : road){
            int nodeA = path[0];
            int nodeB = path[1];
            int weight = path[2];
            
            pathGraph.get(nodeA).add(nodeB);
            pathGraph.get(nodeB).add(nodeA);
            
            weightGraph.get(nodeA).add(weight);
            weightGraph.get(nodeB).add(weight);
        }
        
        pQ.add(new int[]{1, 0});
        
        int[] array = new int[N + 1];
        
        for(int i = 0; i <= N; i++){
            array[i] = Integer.MAX_VALUE;
        }
        
        array[1] = 0;
        
        while(!pQ.isEmpty()){
            int[] curr = pQ.poll();
            int currNode = curr[0];
            int currWeight = array[currNode];
            
            List<Integer> avaliablePath = pathGraph.get(currNode);
            List<Integer> avaliableWeigth = weightGraph.get(currNode);
            
            for(int i = 0; i < avaliablePath.size(); i++){
                int newNode = avaliablePath.get(i);
                int newWeigth = avaliableWeigth.get(i);                
                int candidateWeight = currWeight + newWeigth;
                
                if(array[newNode] > candidateWeight){
                    array[newNode] = candidateWeight;
                    pQ.add(new int[]{newNode, candidateWeight});
                }
            }
        }
        
        for(int i = 1; i < array.length; i++){
            if(K >= array[i]) answer++;
        }
        
        return answer;
    }    
}
