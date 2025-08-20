package 레벨2_문제;

public class 타겟_넘버 {
    int answer = 0; 
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        return answer;
    }
    
    public void dfs(int sum, int idx){
        if( idx >= numbers.length){
            if(sum == target) answer++;
            return;
        }
        dfs(sum + numbers[idx], idx + 1);
        dfs(sum - numbers[idx], idx + 1);            
    }
}
