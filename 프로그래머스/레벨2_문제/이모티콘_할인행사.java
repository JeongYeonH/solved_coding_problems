package 레벨2_문제;

import java.util.ArrayList;
import java.util.List;

public class 이모티콘_할인행사 {

    List<List<Integer>> list = new ArrayList<>();  
    int[] floats = new int[] {10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        cases(emoticons.length, 0, new ArrayList<>());
        
        int join = 0;
        int spend = 0;
        
        for(List<Integer> d : list){
            int caseSpend = 0;
            int caseJoin = 0;
            
            for(int[] user : users){
                int discount = user[0];
                int affordable = user[1];
                
                int userSpend = 0;
                
                for(int i = 0; i < d.size(); i++){
                    if(discount <= d.get(i)){
                        userSpend += emoticons[i] * (100 - d.get(i))/100;
                    }
                }
                
                if(userSpend >= affordable){
                    caseJoin += 1;
                }else{
                    caseSpend += userSpend;
                }
            }
        
            if(caseJoin > join){
                spend = 0;
                
                join = caseJoin;                
                spend = caseSpend;               
            }else if(caseJoin == join && caseSpend > spend){
                spend = caseSpend;
            }
        }
        
        return new int[] { join , spend };
    }
    
    public void cases(int length, int depth, List<Integer> c){
        if(depth >= length){
            list.add(new ArrayList<>(c));
            return;
        }
        
        for(int i = 0; i < floats.length; i ++){
            int fl = floats[i];
            
            c.add(fl);
            depth += 1;
            
            cases(length, depth, c);
            
            c.remove(c.size() - 1);
            depth -= 1;
        }
    }
}
