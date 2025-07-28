package 레벨2_문제;

import java.util.Arrays;

public class 땅따먹기 {
    int solution(int[][] land) {
        for(int i = 0; i < land.length - 1; i++){
            int[] max1 = new int[] {0, 0};
            int[] max2 = new int[] {0, 0};
            for(int j = 0; j < land[i].length; j++){
                int num = land[i][j];
                if(num > max1[0]){
                    max2[0] = max1[0];
                    max2[1] = max1[1];
                    max1[0] = num;
                    max1[1] = j;
                }else if(num == max1[0] && j != max1[1]){
                    if (max2[0] < num) {
                        max2[0] = num;
                        max2[1] = j;
                    }
                }else if(max2[0] < num && num < max1[0]){
                    max2[0] = num;
                    max2[1] = j;
                }
            }
            for(int j = 0; j < land[i + 1].length; j++){
                if(max1[1] != j){
                    land[i + 1][j] += max1[0]; 
                }else{
                    land[i + 1][j] += max2[0];
                }
            }
        }
        int max = Arrays.stream(land[land.length-1]).max().getAsInt();
        return max;
    }
}
