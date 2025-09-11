package 레벨2_문제;

public class 이진_변환_반복하기 {
    public int[] solution(String s) {        
        int count = 0;
        int removed = 0;
        
        while(true){
            StringBuilder sb = new StringBuilder();
        
            for(int i = 0; i < s.length(); i++){
                String str = s.substring(i , i + 1);
                if(str.equals("1")) sb.append(str);
            }

            String fst = sb.toString();
            removed += s.length() - fst.length();
            count++;

            String binary = Integer.toBinaryString(fst.length());
            s = binary;
            
            if(s.equals("1")) break;
            
        }
    
        return new int[]{count , removed};
    }
}
