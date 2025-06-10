package 레벨3_문제;

public class 최고의_집합 {
    public int[] solution(int n, int s) {
        int[] array = new int[n];
        int quotient = s/n;
        if (quotient == 0) return new int[]{-1};
        
        int addValue = s%(quotient*n);;
        for (int i=0; i< n; i++){
            if(i>= n-addValue){
                array[i] = quotient+1;
            }else{
                array[i] = quotient;
            }            
        }       
        return array;
    }
}
