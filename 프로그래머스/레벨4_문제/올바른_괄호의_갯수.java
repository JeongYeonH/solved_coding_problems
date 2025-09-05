package 레벨4_문제;

public class 올바른_괄호의_갯수 {
    int answer = 0;
    
    public int solution(int n) {
        dfs(1, 1, n);
        
        return answer;
    }   
    
    public void dfs(int depth, int used, int n){
        if(used >= n){
            answer++;
            return;
        }

        for(int i = 0; i < 2; i++){
            if(i == 0){
                if(depth < 0) continue;
                dfs(depth + 1, used + 1, n);
            }else{
                if(depth < 0) continue;
                dfs(depth - 1, used, n);
            }
        }    
    }
}
