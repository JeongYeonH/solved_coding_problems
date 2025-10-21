package 레벨2_문제;

public class 연속된_부분_수열의_합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        int sum = 0;
        int minDistance = sequence.length;
        
        for(int i = 0; i < sequence.length; i++){            
            sum += sequence[i];
            right = i;
            
            if(sum > k){
                while(sum > k){
                    sum -= sequence[left];
                    left++;
                }
            }
            
            if(sum == k){
                if(right - left < minDistance){
                    answer[0] = left;
                    answer[1] = right;
                    minDistance = (right - left);
                }

                sum -= sequence[left];
                left++;
            }
        }
        
        
        return answer;
    }
}
