package 레벨2_문제;

public class k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        int answer = 0; 
        int i = 1;
        int num = 1;
        while(true){
            i++;
            num *= k;
            if(num > n) break;
        }
        int[] newNum = new int[i-1];
        int newNumed = i-1;
        int j = 0;
        while(n > 0){
            int pows = newNumed - j - 1;
            int decimal = (int) Math.pow(k, pows);
            int get = 0;
            
            while(true){
                get++;
                int amount = get*decimal;
                if(amount >= n) break;                
            }
            newNum[j] = get - 1;
            int substract = (get-1)*decimal;
            if(j >= newNumed - 1){
                newNum[j] = n;
                n = 0;
            }else{
                n -= substract;
            }
            j++;
        }
        String ss = "";
        for(int t : newNum){
            ss += Integer.toString(t);
        }
        String[] arr = ss.split("0");
        for(String strN : arr){
            if(strN.equals("")) continue;
            long N = Long.parseLong(strN);
            if( N > 1){
                if(isPrime(N)){
                    answer++;
                }
            }           
        }
        return answer;
    }
    
    public boolean isPrime(long k){
        if (k < 2) return false;
        for(int i = 2; i <= Math.sqrt(k); i++){
            if(k%i==0) return false;
        }
        return true;
    } 
}
