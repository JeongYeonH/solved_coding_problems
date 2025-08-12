package 레벨2_문제;

import java.util.*;

public class 메뉴_리뉴얼 {
    public List<String> solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        for(String order : orders){
            char[] charArr = order.toCharArray();
            Arrays.sort(charArr);
            String result = new String(charArr);            
            for(int courseNum : course){
                GetComb(0, "", result, courseNum, map);
            }
        }
        Map<Integer, Integer> maxFreq = new HashMap<>();
        for(Map.Entry<String, Integer> mp : map.entrySet()){
            String str = mp.getKey();
            int num = mp.getValue();
            if(num < 2) continue;
            
            if(!maxFreq.containsKey(str.length())){
                maxFreq.put(str.length(), num);
            }else{
                int val = maxFreq.get(str.length());
                maxFreq.put(str.length(), Math.max(val, num));
            }            
        }
        
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String, Integer> mps : map.entrySet()){
            String comb = mps.getKey();
            int count = mps.getValue();
            if(count >= 2 && count == maxFreq.get(comb.length())){
                ans.add(comb);
            }          
        }
        Collections.sort(ans);        
        return ans;
    }
    
    public void GetComb(int start, String menus, String order, int courseNum, Map<String, Integer> map){
        if(menus.length() == courseNum){
            if(map.containsKey(menus)){
                int val = map.get(menus)+1;
                map.put(menus, val);
            }else{
                map.put(menus, 1);
            }            
            return;
        }        
        for(int i = start; i < order.length(); i++){
            String menu = order.substring(i, i+1);            
            menus = menus + menu;
            start +=1;
            GetComb(start, menus, order, courseNum, map);
            menus = menus.substring(0, menus.length()-1);
        }        
    }
}
