package 레벨2_문제;

import java.util.*;

public class 후보키 {
    Set<List<Integer>> primaryKeys = new HashSet<>();
    
    public int solution(String[][] relation) {
        int col = relation[0].length;
        
        List<Integer> list = new ArrayList<>();        
        
        for(int i = 1; i <= col; i++){
            comb(col, list, i, 0, relation);
        }
        
        return primaryKeys.size();
    }
    
    public void comb(int col, List<Integer> list, int max, int start, String[][] relation){
        if(list.size() >= max){
            for (List<Integer> pk : primaryKeys) {
                if (list.containsAll(pk)) {  
                    return;
                }
            }
            
            boolean isPrimaryKey = isUnique(list, relation);
            
            if(isPrimaryKey) primaryKeys.add(new ArrayList<>(list));

            return;
        }
        
        for(int i = start; i < col; i++){
            list.add(i);           
            comb(col, list, max, i + 1, relation);            
            list.remove(list.size() - 1);
        }
    }
    
    public boolean isUnique(List<Integer> cols, String[][] relation){
        Set<String> unique = new HashSet<>();
        
        for(int i = 0; i < relation.length; i ++){
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < cols.size(); j++){
                int col = cols.get(j);
                String str = relation[i][col];
                sb.append(str);
            }
            
            String s = sb.toString();
            
            if(unique.contains(s)) return false;
            else{
                unique.add(s);
            }
        }
        
        return true;
    }
}
