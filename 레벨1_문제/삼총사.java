package 레벨1_문제;

public class 삼총사 {
    int answer = 0;
    public int solution(int[] number) {
        int[] array = new int[3];      
        dfs(number, array, 0, 0 );       
        return answer;
    }
    
    public void dfs(int[] numbers, int[] arr, int start, int depth){
        if(depth == 3){
            if(arr[0] + arr[1] + arr[2] == 0){
                answer++;
            }
            return;
        }
        for(int i = start; i < numbers.length; i++){            
            arr[depth] = numbers[i];
            dfs(numbers, arr, i+1, depth+1);
        }
    }
}
