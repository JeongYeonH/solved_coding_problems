package 레벨1_문제;

import java.util.*;

public class 소수_찾기 {
    public int solution(int n) {
        List<Integer> arr = new ArrayList<>();
        for(int i=1; i <= n; i++){
            boolean isDecimal = true;
            if(i == 2){
                arr.add(2);
            }else if (i > 2){
                int sqr = (int) Math.sqrt(i);
                for(int j=0; j < arr.size(); j++){
                    int decimal = arr.get(j);
                    if(decimal > sqr) break;
                    if(i%decimal == 0){
                        isDecimal = false;
                        break;
                    }                    
                }
                if(isDecimal) arr.add(i);
            }             
        }
        return arr.size();
    }
}
