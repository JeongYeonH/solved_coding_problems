package 레벨3_문제;

import java.util.*;

public class 자물쇠와_열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int[][] rotated = new int[key.length][key.length];
        List<int[]> lockArr = ablePos(lock, true);
        if(lockArr.isEmpty()) return true;        
        rotated = key;
        
        for(int i = 0; i < 4; i++){
            List<int[]> keyArr = ablePos(rotated, false);            
            List<int[]> moveCoordinate = new ArrayList<>();

            for(int[] k : keyArr){
                for(int[] a : lockArr){
                    moveCoordinate.add(new int[]{k[0]-a[0],k[1]-a[1]});
                }
            }        
            boolean canMatch = isMatch(moveCoordinate, keyArr, lockArr, lock.length);
            if(canMatch) return true;
            rotated = rotate(rotated);
        }        
        return answer;
    }
    
    public int[][] rotate(int[][] key){
        int length = key.length;
        int[][] rotated = new int[length][length];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                rotated[i][j] = key[length - j - 1][i];
            }
        }
        return rotated;
    }
    
    public List<int[]> ablePos(int[][] arr, boolean isZero){
        List<int[]> arrList = new ArrayList<>(); 
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(!isZero && arr[i][j] == 1){
                    arrList.add(new int[]{i, j});
                }
                if(isZero && arr[i][j] == 0){
                    arrList.add(new int[]{i, j});
                }
            }
        }
        return arrList;
    }
    
    public boolean isMatch(List<int[]> candidateMove, List<int[]> keyArr, List<int[]> lockArr, int size){
        boolean match = false;
        for(int[] move : candidateMove){
            List<int[]> remainKeyArr = new ArrayList<>();
            int count = 0;
            for(int i = 0; i < keyArr.size(); i++){
                boolean matched = false;
                int[] key = keyArr.get(i);
                int y = key[0]-move[0];
                int x = key[1]-move[1];
                for(int[] lock : lockArr){
                    if(lock[0] == y && lock[1] == x){
                        count++;
                        matched = true;
                        break;
                    } 
                }
                if(!matched){
                    remainKeyArr.add(new int[] {y, x});
                }          
            }
            
            if(count == lockArr.size()){
                match = true;
            } 
            for(int[] remain : remainKeyArr){
                int reY = remain[0];
                int reX = remain[1];
                if(0 <= reY && reY < size && 0 <= reX && reX < size){
                    match = false;
                }
            }
            if(match) return true;
            
        }            
        return match;
    }
}
