package 레벨2_문제;

public class 점프와_순간이동 {
    public int solution(int n) {
        int energy = 0;
        while(n>0){
            if (n % 2 == 1) {
                energy++;
                n -= 1;
            } else {
                n /= 2;
            }
        }

        return energy;
    }
}
