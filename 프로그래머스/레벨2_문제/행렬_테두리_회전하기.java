package 레벨2_문제;

import java.util.ArrayList;

public class 행렬_테두리_회전하기 {
    public ArrayList<Integer> solution(int rows, int columns, int[][] queries) {
        int[][] array = new int[rows][columns];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i < rows*columns; i++){
            int row = i/columns;
            int col = i%columns;
            array[row][col] = i+1;
        }
        for(int[] query : queries){
            int num = rotateBorder(array, query);
            list.add(num);
        }
        return list;
    }   
    public int rotateBorder(int[][] array, int[] query){
        int minY, minX, maxY, maxX;
        minY = query[0]; minX = query[1]; maxY = query[2]; maxX = query[3];       
        int totalLength = (maxX-minX)*2 + (maxY-minY)*2;
        
        int edge1 = (maxX-minX); 
        int edge2 = edge1+(maxY-minY);
        int edge3 = edge2+edge1;
        
        int formerY = minY-1; int formerX = minX-1;
        int currentNum = 0;
        int smallestNum = 1000000000;
        for(int i=0; i <= totalLength; i++){
            int previousNum = currentNum;
            if(i <= edge1){
                formerY = minY-1; formerX = minX-1+i;
            }else if (edge1 < i && i <= edge2){
                formerY = minY-1+i-edge1; formerX = maxX-1;
            }else if (edge2 < i && i <= edge3){
                formerY = maxY-1; formerX = maxX-1-i+edge2;
            }else if (edge3 < i){
                formerY = maxY-1-i+edge3; formerX = minX-1;
            }
            currentNum = array[formerY][formerX];
            array[formerY][formerX] = previousNum;
            if(previousNum !=0 && previousNum < smallestNum){
                smallestNum = previousNum;
            }
        }
        return smallestNum;
    }  
}
