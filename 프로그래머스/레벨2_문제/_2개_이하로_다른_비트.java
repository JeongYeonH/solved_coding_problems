package 레벨2_문제;

public class _2개_이하로_다른_비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            long num = numbers[i];
            
            if(num%2 == 0){
                answer[i] = num + 1;
            }else{
                answer[i] = num + (Long.lowestOneBit(~num) >> 1);
            }
        }

        return answer;
    }
}
