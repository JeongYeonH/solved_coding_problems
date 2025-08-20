package 레벨3_문제;

import java.util.Arrays;

public class 숫자_게임 {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i < A.length/2; i++){
            int a = A[i];           int b = B[i];
            A[i] = A[A.length-1-i]; B[i] = B[A.length-1-i];
            A[A.length-1-i] = a;    B[A.length-1-i] = b;
        }
        
        int bPos = 0;
        int bWins = 0;
        for (int i = 0; i < A.length; i++) {
            if (bPos >= A.length) break;           
            while (bPos < A.length && A[bPos] >= B[i]) {
                bPos++;
            }
            if (bPos < A.length && A[bPos] < B[i]) {
                bWins++;
                bPos++;
            }
        }
        return bWins;
    }
}
