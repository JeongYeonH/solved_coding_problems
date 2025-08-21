package 레벨3_문제;

public class 기지국_설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int range = w * 2 + 1;
        int covered = 0;
        int idx = 0;
        
        while(covered < n){
            int st = stations[idx] - w;
            int ed = stations[idx] + w;

            if(covered < st - 1){
                answer++; 
                covered += range;
            }else if(st - 1 <= covered){
                if(idx < stations.length - 1){
                    covered = ed;
                    idx++;                   
                }else{
                    if(ed >= n){
                        covered = ed;
                    }else{
                        int remain = n - ed; 
                        int need = (remain + range - 1) / range; 
                        answer += need;
                        covered = n; 
                    } 
                }                
            }
        }
        
        return answer;
    }
}
