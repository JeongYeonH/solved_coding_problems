package 레벨3_문제;

import java.util.*;

public class 양과_늑대 {
    List<List<Integer>> graph = new ArrayList<>();
    int[] info;
    int maxSheep = 0;
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        
        for(int i = 0; i < info.length; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }
        
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        
        int[] begin = new int[2];
        if(info[0] == 0){
            begin[0] +=1;
        }else{
            begin[1] +=1;
        }
        permute(arr, visited, begin);
        return maxSheep;
    }
    
    public void permute(List<Integer> arr, boolean[] visited, int[] sheepNwolf){
        if(sheepNwolf[1] >= sheepNwolf[0]){
            return;
        }
        maxSheep = Math.max(maxSheep, sheepNwolf[0]);
        
        Set<Integer> shouldVisit = new HashSet<>();
        for(int i = 0; i < visited.length; i++){
            if(visited[i]){  
                List<Integer> candidate = graph.get(i);
                for(int j = 0; j < candidate.size(); j++){
                    int candidateNode = candidate.get(j);
                    if(visited[candidateNode]) continue;
                    shouldVisit.add(candidateNode);
                }
            }
        }
        for(Integer i : shouldVisit){
            visited[i] = true;
            arr.add(i);
            
            if(info[i] == 0){
                sheepNwolf[0] +=1;
            }else{
                sheepNwolf[1] +=1;
            }
            
            permute(arr, visited, sheepNwolf);
            
            if(info[i] == 0){
                sheepNwolf[0] -=1;
            }else{
                sheepNwolf[1] -=1;
            }
            
            arr.remove(arr.size() - 1);
            visited[i] = false;
        }        
    }
}
