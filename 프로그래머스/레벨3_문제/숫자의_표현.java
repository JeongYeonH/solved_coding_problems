package 레벨3_문제;

public class 숫자의_표현 {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];
        
        arr[0] = 0;
        arr[1] = 1;
        
        for(int i = 1; i < arr.length; i++){
            arr[i] = (i) + arr[i - 1];
        }
        
        int r = 0;
        int l = 0;
        
        while(r < arr.length){
            int sub = arr[r] - arr[l];
            if(sub < n){
                r++;
            }else if(sub > n){
                l++;
            }else if(sub == n){
                answer++;
                l++;
            }
        }
        
        return answer;
    }
}
