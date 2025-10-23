package 레벨2_문제;

import java.util.*;

public class 숫자_카드_나누기 {
    public int solution(int[] arrayA, int[] arrayB) {      
        int aGCD = findGCD(arrayA);
        int bGCD = findGCD(arrayB);
        
        List<Integer> aList = divisorList(aGCD);
        List<Integer> bList = divisorList(bGCD);
        
        int aMax = getBiggestGCD(aList, arrayB);
        int bMax = getBiggestGCD(bList, arrayA);
        
        return Math.max(aMax, bMax);
    }
    
    public int gcd(int a, int b){
        if(a == 0)
            return b;
        return gcd(b % a, a);
    }
    
    public int findGCD(int[] array){
        int res = array[0];
        
        for(int i = 0; i < array.length; i++){
            res = gcd(array[i], res);
            
            if(res == 1)
                return 1;
        }
        
        return res;
    }
    
    public List<Integer> divisorList(int num){
        List<Integer> divisorList = new ArrayList<>();
        
        for(int i = num; i > 1; i--){
            if (num % i == 0) {
                divisorList.add(i);
            }
        }
        
        return divisorList;
    }
    
    public int getBiggestGCD(List<Integer> GCDarr, int[] array){
        int max = 0;
        
        outer:
        for(int i = 0; i < GCDarr.size(); i++){
            boolean isDivisor = false;
            int divisor = GCDarr.get(i);
            
            for(int j = 0; j < array.length; j++){
                if(array[j] % divisor == 0){
                    isDivisor = true;
                    break;
                }
            }
            
            if(!isDivisor){
                max = divisor;
                break outer;
            } 
        }
        
        return max;
    }
}
