package 레벨2_문제;

import java.util.*;

public class 시소_짝궁 {
    public long solution(int[] weights) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] child = new int[] {1, 3, 2, 4, 3, 2};
        int[] parent = new int[] {2, 4, 3, 3, 2, 1};
        long answer = 0;
               
        for(int weight : weights){

            for(int i = 0; i < parent.length; i++){
                int par = parent[i];
                if(weight%par != 0 ) continue;
                int candidate = (weight/par) * child[i];
                
                if(map.containsKey(candidate)){
                    int value = map.get(candidate);
                    map.put(candidate, value + 1);
                }else{
                    map.put(candidate, 1);
                }                
            }

            if(map.containsKey(weight)){
                int val = map.get(weight);
                System.out.println(" ");
                answer += val;
                map.put(weight, val + 1);
            }else{
                map.put(weight, 1);
            }
        }

        return answer;
    }
}
