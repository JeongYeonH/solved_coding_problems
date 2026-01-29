package 레벨2_문제;

import java.util.*;

public class 교점에_별_만들기 {
    public String[] solution(int[][] line) {
        List<long[]> arr = new ArrayList<>();
        
        long maxX = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
                
        for(int i = 0; i < line.length - 1; i++){
            for(int j = i + 1; j < line.length; j++){
                long parent = (long)line[i][0] * line[j][1] - (long)line[i][1] * line[j][0];
                
                if(parent == 0) continue;
                
                double meetX = (double)((long)line[i][1] * line[j][2] - (long)line[i][2] * line[j][1]) / parent;
                double meetY = (double)((long)line[i][2] * line[j][0] - (long)line[i][0] * line[j][2]) / parent;
                
                if(meetX % 1 != 0 || meetY % 1 != 0) continue;                 
                
                long x = (long) meetX;
                long y = (long) meetY;
                
                arr.add(new long[] { x, y });   
                maxX = Math.max(maxX, x);
                minX = Math.min(minX, x);
                maxY = Math.max(maxY, y);
                minY = Math.min(minY, y);
            }
        }
        
        int length = (int)(maxX - minX + 1);  
        int height = (int)(maxY - minY + 1);
        String[] ans = new String[height];
        String lDot = ".".repeat(length);        
        
        for(int i = 0; i < ans.length; i++){
            ans[i] = lDot;
        }
        
        for(int i = 0; i < arr.size(); i++){
            long[] corr = arr.get(i);
            int adjustX = (int)(corr[0] - minX);
            int adjustY = (int)(corr[1] - minY);
            
            StringBuilder sb = new StringBuilder(ans[height - adjustY - 1]);
            sb.setCharAt(adjustX, '*');
            ans[height - adjustY - 1] = sb.toString();
        }
        
        return ans;
    }
}
