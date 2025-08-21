package 레벨1_문제;

public class 숫자_짝궁 {
    public String solution(String X, String Y) {
        
        int[] x = new int[10];
        int[] y = new int[10];
        
        for(int i = 0; i < X.length(); i++ ){
            int stx = Integer.parseInt(X.substring(i , i + 1));
            x[stx] += 1;
        }
        
        for(int i = 0; i < Y.length(); i++ ){
            int sty = Integer.parseInt(Y.substring(i , i + 1));
            y[sty] += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 9; i >= 0; i--){
            int min = Math.min(x[i], y[i]);
            for(int j = 0; j < min; j++){
                sb.append(i);
            }
        }
        
        if(sb.length() == 0) return "-1";
        if(sb.charAt(0) == '0') return "0";  
        
        return sb.toString();
    } 
}
