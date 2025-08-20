package 레벨2_문제;

public class _2_x_n_타일링 {
    public int solution(int n) {
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for(int i=2; i < n; i++){
            int sum = result[i-1] + result[i-2];
            result[i] = sum%1000000007;
        }
        return result[n-1];
    }
}
