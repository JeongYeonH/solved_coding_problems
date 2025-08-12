package 레벨2_문제;

public class n제곱의2_배열_자르기 {
    public int[] solution(int n, long left, long right) {
        int[] array = new int[(int)(right-left+1)];
        long start = (left / n) * n;
        long end = (right / n) * n;
        
        for(long i = start; i <= end+n; i += n){       
            if(i%n==0 && i > 0){               
                for(long j = i-1; j >= i - n; j--){
                    if (j < left || j > right) continue;
                        int r = (int)(j / n);
                        int c = (int)(j % n);
                        array[(int)(j - left)] = Math.max(r, c) + 1;
                }  
            }
            if(i > right) break;
            
        }

        return array;
    }
}
