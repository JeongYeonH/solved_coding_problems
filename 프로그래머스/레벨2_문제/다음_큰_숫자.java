package 레벨2_문제;

public class 다음_큰_숫자 {
    public int solution(int n) {
        int totalOnes = 0;  
        String binary = Integer.toBinaryString(n);
        
        for(int i = 0; i < binary.length(); i++){
            String str = binary.substring(i , i + 1);
            
            if(str.equals("1")) totalOnes++;
        }
        
        while(true){
            n++;

            int newTotalOnes = 0;           
            String newBinary = Integer.toBinaryString(n);
            
            for(int i = 0; i < newBinary.length(); i++){
                String newStr = newBinary.substring(i , i + 1);

                if(newStr.equals("1")) newTotalOnes++;
            }   
            
            if(newTotalOnes == totalOnes){
                return n;
            }            
        }
    }
}
