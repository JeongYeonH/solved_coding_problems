package 레벨2_문제;

public class _124_나라의_숫자 {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        while(n > 0){
            int num = n%3;
            

            if(num == 0){
                answer.append(4);
                n = n/3 - 1;
            }else{
                answer.append(num);
                n = n/3;
            }
        }
        
        return answer.reverse().toString();
    }   
}
