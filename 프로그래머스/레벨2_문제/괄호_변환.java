package 레벨2_문제;

import java.util.Stack;

public class 괄호_변환 {
    public String solution(String p) {    
        String ans = recurse(p);

        return ans;
    }
    
    public String recurse(String p){
        if(p.equals("")) return "";
        
        int balance = 0;
        boolean isU = true;
        boolean isRight = true;
        
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        
        String u = "";
        String v = "";
        boolean[] rights = new boolean[2];
        
        for(int i = 0; i < p.length(); i++){
            String s = p.substring(i, i + 1);
            
            if(s.equals("(")){
                balance++;
                stack.add("(");
            }else if(s.equals(")")){
                balance--;
                if(!stack.isEmpty()) stack.pop();
                else if(stack.isEmpty()) isRight = false;
            }  
            
            sb.append(s);
            
            if(balance == 0 && isU){
                if(!stack.isEmpty()) isRight = false;
                
                u = sb.toString();
                rights[0] = isRight;
                
                isU = false;
                isRight = true;
                sb = new StringBuilder();
            } 
        }
        
        if(!stack.isEmpty()) isRight = false;
        
        v = sb.toString();
        rights[1] = isRight;
        
        if(rights[0]){
            StringBuilder sbs = new StringBuilder();
            String newS = recurse(v);
            sbs.append(u);
            sbs.append(newS);

            return sbs.toString();
        }else if(!rights[0]){
            StringBuilder sbs = new StringBuilder();
            String mid = recurse(v);
            String newS = invert(u);
            
            sbs.append("(");            
            sbs.append(mid);
            sbs.append(")");            
            sbs.append(newS);

            return sbs.toString();
        }
        
        return " ";
    }
    
    public String invert(String s){
        if(s.length() <= 2) return "";
        else if(s.length() > 2){            
            StringBuilder sb = new StringBuilder();
            String newS = s.substring(1, s.length() - 1);

            for(int i = 0; i < newS.length(); i++){
                String S = newS.substring(i, i + 1);
                
                if(S.equals("(")) sb.append(")");
                else if(S.equals(")")) sb.append("(");
            }
            
            return sb.toString();
        }
        
        return "";
    }
}
