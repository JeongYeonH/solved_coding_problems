package 레벨3_문제;

import java.util.*;

public class 여행경로 {
    Map<String, Integer> map = new HashMap<>();
    List<List<String>> answer = new ArrayList<>();
    
    public List<String> solution(String[][] tickets) {        
        Arrays.sort(tickets, (a,b) -> {
            int cmp = a[0].compareTo(b[0]);
            if(cmp == 0) return a[1].compareTo(b[1]);
            return cmp;
        });
        boolean[] visited = new boolean[tickets.length];
        
        for(int i = 0; i < tickets.length; i++){
            if(!map.containsKey(tickets[i][0])){
                map.put(tickets[i][0], i);
            }
        }  
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", tickets, path, visited);
        
        return answer.get(0);
    }
    
    public boolean dfs(String airport, String[][] tickets, List<String> path, boolean[] visited){
        if(path.size() == tickets.length + 1){            
            answer.add(new ArrayList<>(path)); 
            return true;
        }
                
        Integer idx = map.get(airport);
        if(idx == null) return false;
        while(idx < tickets.length && tickets[idx][0].equals(airport)){
            if(!visited[idx]){                
                path.add(tickets[idx][1]);
                visited[idx] = true;
                dfs(tickets[idx][1], tickets, path, visited);
                path.remove(path.size() - 1);
                visited[idx] = false;
            }
            idx++;
        }
        return false;
    }
}
