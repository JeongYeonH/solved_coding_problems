package 레벨1_문제;

import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        int pivot = getIndex(ext);
        int sortIdx = getIndex(sort_by);
        
        for(int i = 0; i < data.length; i++){
            int[] row = data[i];
            int rowsExt = row[pivot];
            
            if(rowsExt < val_ext) list.add(row);
        }
        
        list.sort((a, b) -> a[sortIdx] - b[sortIdx]);
        
        int[][] answer = new int[list.size()][4];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public int getIndex(String word){
        int pivot = 0;
        
        switch(word){
            case "date":
                pivot = 1;
                break;
            case "code":
                pivot = 0;
                break;
            case "maximum":
                pivot = 2;
                break;
            case "remain":
                pivot = 3;
                break;
            default:
                break;
        }
        
        return pivot;
    }    
}
