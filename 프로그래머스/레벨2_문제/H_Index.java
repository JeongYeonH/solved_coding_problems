package 레벨2_문제;

import java.util.Arrays;

public class H_Index {
    public int solution(int[] citations) {     
        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++){
            int numOfArticles = citations.length - i;

            if(numOfArticles <= citations[i]){
                return numOfArticles;
            }
        }
                
        return 0;
    }
}
