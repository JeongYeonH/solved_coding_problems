package 레벨2_문제;

import java.util.*;

public class 서버_증설_횟수 {
    public int solution(int[] players, int m, int k) {  
        int count = 0;
        int serverSize = m - 1;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < players.length; i++){
            int currPlayers = players[i];
            
            if(q.size() != 0){
                int addedServer = q.peek();
                int lasts = addedServer + k;
                
                if(i >= lasts){
                    while(q.size() != 0 && i >= (q.peek() + k)){
                        serverSize -= m;
                    }
                }
            }
                        
            if(serverSize < currPlayers){
                while(serverSize < currPlayers){
                    serverSize += m;
                    q.add(i);
                    count++;
                }
            }
        }
        
        return count;
    }   
}
