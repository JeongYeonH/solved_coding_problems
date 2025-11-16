package 레벨2_문제;

public class 숫자_블록 {
    public int[] solution(long begin, long end) {
        int[] array = new int[(int)(end - begin) + 1];
        
        for(long i = begin; i <= end; i++){
            int idx = (int)(i - begin);            
            
            array[idx] = getBlock(i);           
        }

        return array;
    }
    
    private int getBlock(long n) {
        if (n == 1) return 0;

        int maxDiv = 1;
        for (long j = 2; j * j <= n; j++) {
            if (n % j == 0) {
                long d = n / j;
                if (d <= 10000000) {
                    return (int)d; 
                }
                if (j <= 10000000) {
                    maxDiv = (int)j; 
                }
            }
        }
        return maxDiv;
    }
}
