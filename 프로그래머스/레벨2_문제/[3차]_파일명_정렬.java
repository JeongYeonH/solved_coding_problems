package 레벨2_문제;

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];       
        PriorityQueue<String[]> pQ = new PriorityQueue<>((a, b) ->{
            int cmp = a[0].compareToIgnoreCase(b[0]);
            
            if(cmp == 0){
                int aNum = Integer.parseInt(a[1]);
                int bNum = Integer.parseInt(b[1]);
                
                if(aNum == bNum){
                    int aIdx = Integer.parseInt(a[2]);
                    int bIdx = Integer.parseInt(b[2]);
                    
                    return aIdx - bIdx;
                }
                return aNum - bNum;
            }
            return cmp;
        });
        
        for(int i = 0; i < files.length; i++){
            StringBuilder sb = new StringBuilder();
            String[] sets = new String[3]; 
            String file = files[i];
            
            boolean isHeader = true;
            
            for(int j = 0; j < file.length(); j++){
                String str = file.substring(j , j + 1);
                
                if(isHeader && !str.matches("^[0-9]*$")){
                    sb.append(str);
                }
                
                if(str.matches("^[0-9]*$") && isHeader){
                    sets[0] = sb.toString();
                    sb.setLength(0);
                    isHeader = false;
                }
                
                if(!isHeader && str.matches("^[0-9]*$")){
                    sb.append(str);
                }
                
                if(!isHeader && !str.matches("^[0-9]*$") || !isHeader && j >= (file.length() - 1)){
                    sets[1] = sb.toString();
                    sets[2] = Integer.toString(i);
                    
                    sb.setLength(0);
                    pQ.add(sets);
                    
                    break; 
                }
            }
        }
        
        for(int i = 0; i < files.length; i++){
            String[] strings = pQ.poll();
            int idxs = Integer.parseInt(strings[2]);
            answer[i] = files[idxs];
        }
        
        return answer;
    }
}
