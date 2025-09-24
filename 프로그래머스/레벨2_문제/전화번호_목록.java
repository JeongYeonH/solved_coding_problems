package 레벨2_문제;

import java.util.*;
public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        boolean answer = true;
        
        for(String phone_num : phone_book){
            set.add(phone_num);  
        }
        
        for(int i = 0; i < phone_book.length; i++){
            String nums = phone_book[i];
            for(int j= 0; j < nums.length() - 1; j++){
                String sub = nums.substring(0, j + 1);
                
                if(set.contains(sub)) return false;
            }
        }
        return answer;
    }
}
