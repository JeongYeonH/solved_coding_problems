package 레벨2_문제;

public class 택배_배달과_수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int d = n - 1;
        int p = n - 1;

        while (d >= 0 || p >= 0) {
            while (d >= 0 && deliveries[d] == 0) d--;
            while (p >= 0 && pickups[p] == 0) p--;

            if (d < 0 && p < 0) break;

            answer += (Math.max(d, p) + 1) * 2;

            int dCap = cap;
            int pCap = cap;

            while (d >= 0 && dCap > 0) {
                if (deliveries[d] <= dCap) {
                    dCap -= deliveries[d];
                    deliveries[d] = 0;
                    d--;
                } else {
                    deliveries[d] -= dCap;
                    break;
                }
            }

            while (p >= 0 && pCap > 0) {
                if (pickups[p] <= pCap) {
                    pCap -= pickups[p];
                    pickups[p] = 0;
                    p--;
                } else {
                    pickups[p] -= pCap;
                    break;
                }
            }
        }

        return answer;
    }    
}
