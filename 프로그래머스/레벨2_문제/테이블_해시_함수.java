package 레벨2_문제;

import java.util.ArrayList;
import java.util.List;

public class 테이블_해시_함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {     
        List<int[]> list = new ArrayList<>();
        
        for(int[] d : data){
            list.add(d);
        }
        
        list.sort((a, b) -> {
            if(a[col - 1] == b[col - 1]){
                return b[0] - a[0];
            }
            
            return a[col - 1] - b[col - 1];
        } );
        
        int prev = 0;
        
        for(int i = row_begin - 1; i < row_end; i++){
            int S_i = 0;
            
            for(int j = 0; j < list.get(i).length; j++){
                S_i += list.get(i)[j] % (i + 1);
            }
            
            prev = (prev ^ S_i);
        }
        
        return prev;
    }    
}
