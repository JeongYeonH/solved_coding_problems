package 레벨3_문제;

import java.util.Stack;

public class 표_편집 {
    public String solution(int n, int k, String[] cmd) {
        Stack<int[]> stack = new Stack<>();
        boolean[] removed = new boolean[n];
        
        int[] next = new int[n];
        int[] prev = new int[n];
        
        for(int i = 0; i < n; i++){
            next[i] = i + 1;
        }
            
        for(int i = n - 1; i > 0; i--){
            prev[i] = i - 1;
        }
        
        next[n - 1] = -1;
        prev[0] = -1;
        
        for(int i = 0; i < cmd.length; i++){
            String command = cmd[i];
            String[] cmdLine = command.split(" ");
            String com = cmdLine[0];
            
            switch(com){
                case "U":
                    int up = Integer.parseInt(cmdLine[1]);

                    while(up > 0){
                        k = prev[k];
                        up--;
                    }
                    
                    break;
                case "D":
                    int down = Integer.parseInt(cmdLine[1]);
                    
                    while(down > 0){
                        k = next[k];
                        down--;
                    }
                    
                    break;
                case "C":
                    stack.add(new int[]{k, prev[k], next[k]});
                    removed[k] = true;
                    
                    if (next[k] != -1) prev[next[k]] = prev[k];
                    if (prev[k] != -1) next[prev[k]] = next[k];
                    
                    if(next[k] != -1) k = next[k];
                    else k = prev[k];
                                    
                    break;
                case "Z":
                    int[] recover = stack.pop();                         
                    int dec = recover[0];
                    int prev_k = recover[1];
                    int next_k = recover[2];
                    
                    removed[dec] = false;
                    
                    if (prev_k != -1) next[prev_k] = dec;
                    if (next_k != -1) prev[next_k] = dec;
                    
                    break;
                default:
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < removed.length; i++){
            if(removed[i]) sb.append("X");
            else sb.append("O");
        }

        return sb.toString();
    }
}
