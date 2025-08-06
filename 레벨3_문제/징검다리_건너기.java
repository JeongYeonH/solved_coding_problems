package 레벨3_문제;

public class 징검다리_건너기 {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        int low = 1;
        int high = 200000000;
        while(low <= high){
            int mid =(low + high)/2;
            if(canCross(mid, stones, k)){
                answer = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return answer;
    }
    
    public boolean canCross(int mid, int[] stones, int k){
        int cases = 0;
        for(int stone : stones){
            if(stone-mid < 0){
                cases++;
                if(cases >= k) return false;
            }else{
                cases = 0;
            }
        }
        return true;
    }
}
