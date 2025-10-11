package 레벨2_문제;

import java.util.*;

public class 소수_찾기 {
    Set<Integer> set = new HashSet<>();
    int maxNum = 0;
    
    public int solution(String numbers) {
        int answer = 0;
        String[] arr = numbers.split("");

        boolean[] visited = new boolean[arr.length];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= arr.length; i++){
            comb(visited, arr, sb, i);
        }
        
        int[] eratostenes = new int[maxNum + 1];
        eratostenes[0] = 1;
        eratostenes[1] = 1;
        
        for(int i = 2; i * i  < eratostenes.length; i++){
            if(eratostenes[i] == 1) continue;
            
            for(int j = i * i; j < eratostenes.length; j += i){
                eratostenes[j] = 1;
            }
        }
        
        for(int n : set){
            if(eratostenes[n] == 0){
                answer++;
            }
        }
        
        return answer;
    }
    
    
    
    public void comb(boolean[] visited, String[] arr, StringBuilder sb, int length){
        if(sb.length() >= length){
            int result = Integer.parseInt(sb.toString());
            maxNum = Math.max(maxNum, result);
            set.add(result);
            return;
        }
        
        for(int i = 0; i < arr.length; i++){
            String s = arr[i];
            
            if(visited[i]) continue;
            visited[i] = true;
            
            sb.append(s);
            comb(visited, arr, sb, length);
            sb.setLength(sb.length() - 1);
            
            visited[i] = false;
        }
    }
}
