package 레벨2_문제;

import java.util.Stack;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++){
            if(!stack.isEmpty()){
                int[] element = stack.peek();
                
                if(element[0] > prices[i]){
                    while(element[0] > prices[i]  && !stack.isEmpty()){
                        element = stack.pop();
                        answer[element[1]] = i - element[1];
                        
                        if (!stack.isEmpty()) {
                            element = stack.peek();
                        } else {
                            break; 
                        }
                    } 
                    
                    stack.add(new int[]{prices[i], i});
                }else{
                    stack.add(new int[]{prices[i], i});
                }
            }else{
                stack.add(new int[]{prices[i], i });
            }     
            
        }
        
        while(!stack.isEmpty()){
            int[] element = stack.pop();
            answer[element[1]] = (prices.length - 1) - element[1];
        }
        return answer;
    }
}
