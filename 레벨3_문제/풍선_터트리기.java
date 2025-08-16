package 레벨3_문제;

public class 풍선_터트리기 {
    public int solution(int[] a) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        
        for(int i = 0; i < a.length; i++){
            if(min > a[i]){
                min = a[i];
                minIdx = i;
            }
        }
        
        int minRight = Integer.MAX_VALUE;
        for(int i = 0; i < minIdx; i++){
            if(minRight > a[i]){
                answer++;
                minRight = a[i];
            }
        }
        
        int minLeft = Integer.MAX_VALUE;
        for(int i = a.length - 1; i > minIdx; i--){
            if(minLeft > a[i]){
                answer++;
                minLeft = a[i];
            }
        }
        
        answer += 1;
        return answer;
    }
}
