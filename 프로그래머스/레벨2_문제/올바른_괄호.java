package 레벨2_문제;

import java.util.Stack;

public class 올바른_괄호 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stackStr = new Stack<>();
        char [] charArr = s.toCharArray();
        
        for(char cha : charArr){
            if(cha == '('){
                stackStr.push("괄호");
            }else if(cha == ')'){
                if(!stackStr.empty()){
                    stackStr.pop();
                }else if(stackStr.empty()){
                    answer = false;
                    return answer;
                }
            }
        }
        if(!stackStr.empty()){
            answer = false;
        }
        return answer;
    }
}
