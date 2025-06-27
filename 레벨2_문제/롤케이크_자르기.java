package 레벨2_문제;

import java.util.*;

public class 롤케이크_자르기 {
    public int solution(int[] topping) {
        Set<Integer> backward = new HashSet<>();
        Set<Integer> forward = new HashSet<>();
        int[] backArr = new int[topping.length];
        for(int i= topping.length-1; i >= 0; i--){
            backward.add(topping[i]);
            backArr[i] = backward.size();
        }
        
        int answer = 0;
        for(int i = 0; i < topping.length-1; i++){
            forward.add(topping[i]);
            if(forward.size() == backArr[i+1]){
                answer++;
            }
        }
        
        return answer;
    }
}
