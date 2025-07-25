package 레벨2_문제;

import java.util.*;

public class 예상_대진표 {
    int n;
    public int solution(int n, int a, int b)
    {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        this.n = n;
        int exponent = Integer.numberOfTrailingZeros(n);
        List<Integer> arr = new ArrayList<>();
        arr.add(n/2);
        int ans = count(arr, exponent, small, big);
        return ans;
    }

    public int count(List<Integer> arr, int exponent, int a, int b){   
        for(int i = 0; i < arr.size(); i++){
            if(a <= arr.get(i) && arr.get(i) < b){
                return exponent;
            }
        }
        exponent--;
        int gap = (int) Math.pow(2, exponent - 1);
        for(int i = 0; i <= n; i += gap){
            if(!arr.contains(i) && i != 0){
                arr.add(i);
            }
        }
        return count(arr, exponent, a, b);
    }
}
