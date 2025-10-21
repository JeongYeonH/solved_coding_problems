package 레벨2_문제;

import java.util.Stack;

public class 큰_수_만들기 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < number.length(); i++){
            char c = number.charAt(i);
            
            while(!stack.isEmpty() && stack.peek() < c && k > 0){
                stack.pop();
                k--;
            }
            
            stack.push(c);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        for (char ch : stack){
            sb.append(ch);
        }
            
        return sb.toString();
    }   
}
