package 레벨2_문제;

import java.util.*;

public class 연속_부분_수열_합의_개수 {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] doubled = new int[elements.length*2];
        
        for(int i = 0; i < elements.length*2; i++){
            doubled[i] = elements[i%elements.length];
        }

        for(int i = 1; i <= elements.length; i++){
            int totalLength = doubled.length - i;
            for(int j = 0; j < totalLength; j++){
                int sum = 0;
                for(int k = j; k < j + i; k++){
                    sum += doubled[k];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}
