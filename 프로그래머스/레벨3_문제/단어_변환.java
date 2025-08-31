package 레벨3_문제;

import java.util.*;

public class 단어_변환 {
    public int solution(String begin, String target, String[] words) {    
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        
        int depth = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                String wrd = q.poll();
                
                if(wrd.equals(target)){
                    answer = depth;
                    break;
                } 
                
                for(int n = 0; n < words.length; n++){
                    String sampleWord = words[n];
                    int match = 0;
                    
                    if(visited[n]) continue;
                    
                    for(int j = 0; j < sampleWord.length(); j++){
                        String ow = wrd.substring(j, j + 1);
                        String sw = sampleWord.substring(j, j + 1);
                        
                        if(ow.equals(sw)) match++;
                    }
                    
                    if(match == sampleWord.length() - 1){
                        visited[n] = true;
                        q.add(sampleWord);
                    }
                }                             
            }
            depth++;
        }
        
        return answer;
    }
}
