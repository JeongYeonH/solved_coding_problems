package 레벨2_문제;

import java.util.*;

public class 방문_길이 {
    public int solution(String dirs) {
        Set<List<Double>> set = new HashSet<>();                
        int[] prev = new int[] {0, 0};
        int answer = 0;
        
        for(int i = 0; i < dirs.length(); i++){
            String dir = dirs.substring(i, i + 1);
            int[] curr = new int[] {0, 0};
            
            switch(dir){
                case "U":
                    curr[0] = prev[0];
                    curr[1] = prev[1] + 1;
                    break;
                case "L":
                    curr[0] = prev[0] - 1;
                    curr[1] = prev[1];
                    break;
                case "R":
                    curr[0] = prev[0] + 1;
                    curr[1] = prev[1];
                    break;
                case "D":
                    curr[0] = prev[0];
                    curr[1] = prev[1] - 1;
                    break;
                default:
                    break;
            }
            
            if(curr[0] < -5 || curr[0] > 5) continue;
            if(curr[1] < -5 || curr[1] > 5) continue;
            
            double x = (double)(curr[0]+prev[0])/2;
            double y = (double)(curr[1]+prev[1])/2;
            
            prev[0] = curr[0];
            prev[1] = curr[1];
            
            if(!set.contains(Arrays.asList(x, y))){
                answer++;
                set.add(Arrays.asList(x, y));
            }            
        }
        
        return answer;
    }
}
