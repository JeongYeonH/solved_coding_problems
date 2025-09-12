package 레벨2_문제;

import java.util.Stack;

public class 짝지어_제거하기 {
    public int solution(String s){        
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(i , i + 1);
            stack.add(str);
            if(stack.size() >= 2){
                String top = stack.peek();
                String sec = stack.get(stack.size() - 2);
                
                if(top.equals(sec)){
                    stack.pop();
                    stack.pop();
                }
            }
        }        
        
        return stack.isEmpty() ? 1 : 0;
    }
}
