package 레벨2_문제;

import java.util.Stack;

public class 괄호_회전하기 {
    public int solution(String s) {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        String S = s + s;

        for(int i = 0; i < s.length(); i++){
            boolean searching = true;
            outerloop:
            for(int j = i; j < i + s.length(); j++){
                String str = S.substring(j, j + 1);
                switch(str){
                    case "(":
                        stack.add("(");
                        break;
                    case "[":
                        stack.add("[");
                        break;
                    case "{":
                        stack.add("{");
                        break;
                    case ")":
                        if(stack.isEmpty()){
                            searching = false;
                            break outerloop;
                        }else{
                            String st = stack.peek();
                            if(st.equals("(")){
                                stack.pop();
                                break;
                            }else{
                                searching = false;
                                break outerloop;
                            }                            
                        }
                    case "]":
                        if(stack.isEmpty()){
                            searching = false;
                            break outerloop;
                        }else{
                            String st = stack.peek();
                            if(st.equals("[")){
                                stack.pop();
                                break;
                            }else{
                                searching = false;
                                break outerloop;
                            } 
                        }
                    case "}":
                        if(stack.isEmpty()){
                            searching = false;
                            break outerloop;
                        }else{
                            String st = stack.peek();
                            if(st.equals("{")){
                                stack.pop();
                                break;
                            }else{
                                searching = false;
                                break outerloop;
                            } 
                        }
                    default:
                        break;                        
                }

            }
            if(stack.isEmpty() && searching){
                answer++;
            }
        }
        return answer;
    }
}
