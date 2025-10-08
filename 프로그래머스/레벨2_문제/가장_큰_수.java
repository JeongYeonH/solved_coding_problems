package 레벨2_문제;

import java.util.*;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        
        for (int num : numbers) list.add(num);
        
        list.sort((a, b) -> {
            String aStr = Integer.toString(a);
            String bStr = Integer.toString(b); 

            return (bStr + aStr).compareTo(aStr + bStr);
        });
        
        if (list.get(0) == 0) return "0";

        StringBuilder sb = new StringBuilder(); 

        for (int num : list) sb.append(num);    
           
        return sb.toString();
    }
}
