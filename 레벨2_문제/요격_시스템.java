package 레벨2_문제;

import java.util.Arrays;

public class 요격_시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        int[][] sortedTargets = Arrays.stream(targets)
                                    .sorted((a,b) -> a[1]-b[1])
                                    .toArray(size -> new int[size][]);
        double launchPoint = -1;
        for(int i = 0; i < targets.length; i++){
            int[] target = sortedTargets[i];
            if(launchPoint <= target[0]){
                launchPoint = target[1];
                
                answer++;
            }
        }
        return answer;
    }
}
