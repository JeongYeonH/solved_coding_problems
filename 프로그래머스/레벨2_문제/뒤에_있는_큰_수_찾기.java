package 레벨2_문제;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {
    public int[] solution(int[] numbers) {
        int[] ans = new int[numbers.length];
        Arrays.fill(ans, -1);       
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < numbers.length; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                int idx = stack.pop();
                ans[idx] = numbers[i];
            }
            stack.add(i);
        }
        return ans;
    }
}
