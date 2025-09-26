package 레벨2_문제;

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int son = 0;
        int parent = 0;
        
        PriorityQueue<String> pQ1 = new PriorityQueue<>();
        PriorityQueue<String> pQ2 = new PriorityQueue<>();
        
        String STR1 = str1.toUpperCase();
        String STR2 = str2.toUpperCase();
        
        for(int i = 0; i < STR1.length() - 1; i++){
            String fst = STR1.substring(i, i + 1);
            String sec = STR1.substring(i + 1, i + 2);
            
            if(fst.matches("^[A-Z]*$") && sec.matches("^[A-Z]*$")){
                StringBuilder sb = new StringBuilder();                
                sb.append(fst);
                sb.append(sec);
                
                String st = sb.toString();                
                pQ1.add(st);
            }
        }

        for(int i = 0; i < STR2.length() - 1; i++){
            String fst = STR2.substring(i, i + 1);
            String sec = STR2.substring(i + 1, i + 2);
            
            if(fst.matches("^[A-Z]*$") && sec.matches("^[A-Z]*$")){
                StringBuilder sb = new StringBuilder();                
                sb.append(fst);
                sb.append(sec);
                
                String st = sb.toString();                
                pQ2.add(st);
            }
        }
        
        if(pQ1.isEmpty() && pQ2.isEmpty()) return 65536;
        else if(pQ1.isEmpty()) return 0;
        else if(pQ2.isEmpty()) return 0;
        
        while(true){
            String st1 = pQ1.peek();
            String st2 = pQ2.peek();
            
            int compare = st1.compareTo(st2);
                
            if(compare < 0 ){
                pQ1.poll();
                parent++;
            }else if(compare > 0){
                pQ2.poll();
                parent++;
            }else{
                pQ1.poll();
                pQ2.poll();
                son++;
                parent++;
            }
                        
            if(pQ1.isEmpty() || pQ2.isEmpty()) break;
        }
        
        
        if(!pQ1.isEmpty()){
            while(!pQ1.isEmpty()){
                pQ1.poll();
                parent++;
            }
        }

        if(!pQ2.isEmpty()){
            while(!pQ2.isEmpty()){
                pQ2.poll();
                parent++;
            }
        }

        double answer = (double) son / (double) parent;
        answer *= 65536;
        
        return (int) answer;
    }
}
