package 레벨3_문제;

public class 카운트_다운 {
    public int[] solution(int target) {
        int[][] arr = new int[target + 1][2];

        for(int i = 1; i <= target; i++){
            int[] pair = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};

            for(int j = 1; j <= 20; j++){                                
                int[] mins = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
                int[][] cases = new int[4][2];

                if(i - j >= 0){
                    int[] prev1 = arr[i - j];
                    cases[0][0] = prev1[0] + 1;
                    cases[0][1] = prev1[1] + 1;
                }

                if(i - (j * 2) >= 0){
                    int[] prev2 = arr[i - (j * 2)];
                    cases[1][0] = prev2[0] + 1;
                    cases[1][1] = prev2[1];
                }

                if(i - (j * 3) >= 0){
                    int[] prev3 = arr[i - (j * 3)];
                    cases[2][0] = prev3[0] + 1;
                    cases[2][1] = prev3[1];
                }

                if(i - 50 >= 0){
                    int[] prev4 = arr[i - 50];
                    cases[3][0] = prev4[0] + 1;
                    cases[3][1] = prev4[1] + 1;
                }

                for(int k = 0; k < 4; k++){
                    int[] curr = cases[k];

                    if(curr[0] == 0 && curr[1] == 0) continue;
                    if(mins[0] > curr[0]) mins = curr;
                    else if(mins[0] == curr[0] && mins[1] < curr[1]){
                        mins = curr;
                    }
                }

                if(pair[0] > mins[0]) pair = mins;
                else if(pair[0] == mins[0] && pair[1] < mins[1]){
                    pair = mins;
                }
            }  
            arr[i] = pair;
        }

        return arr[target];
    }
}
