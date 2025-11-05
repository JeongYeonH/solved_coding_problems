package 레벨2_문제;

import java.util.*;

public class 우박수열_정적분 {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> list = new ArrayList<>();
        List<Double> areas = new ArrayList<>();
        
        int prev = k;
        list.add(k);
        
        while(k != 1){
            if(k % 2 == 0){
                k /= 2;
            }else{
                k = k * 3 + 1;
            }
            
            list.add(k);
            
            double area = (double)(prev + k) / 2;
            areas.add(area);
            prev = k;
        }
        
        double[] integral = new double[ranges.length];
        
        for(int j = 0; j < ranges.length; j++){
            int[] range = ranges[j];
            int start = range[0];
            int end = areas.size() + range[1];
            
            if(end < start){
                integral[j] = -1.0;
                continue;
            } else if(end == start){
                integral[j] = 0.0;    
                continue;
            } 
            
            double sum = 0;
            
            for(int i = start; i < end; i++){
                sum += areas.get(i);
            }
            
            integral[j] = sum;
        }
        
        return integral;
    }
}
