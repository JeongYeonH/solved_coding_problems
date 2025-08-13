package 레벨2_문제;

import java.util.*;

public class 최솟값_만들기 {
        public int solution(int []A, int []B){
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < A.length; i++){
            int idx = A.length - i - 1;
            answer += A[i]*B[idx];
        }
        return answer;
    }
}
