package 레벨2_문제;

import java.util.Stack;

public class 택배상자 {
    public int solution(int[] order) {    
        Stack<Integer> stack = new Stack<>();
        
        int answer = 0;
        int begin = 1;

        for(int i = 0; i < order.length; i++){    
            if(stack.isEmpty()){
                for(int j = begin; j < order[i]; j++){
                    stack.add(j);
                }

                begin = order[i] + 1;
                answer++;
            }else{
                int top = stack.peek();

                if(top == order[i]){
                    stack.pop();
                    answer++;
                }else if(order[i] > top){
                    for(int j = begin; j < order[i]; j++){
                        stack.add(j);
                    }

                    begin = order[i] + 1;
                    answer++;
                }else{
                    break;
                }
            }
        }

        return answer;
    }
}
