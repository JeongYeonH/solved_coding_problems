package 레벨1_문제;

public class _1차_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i < n; i++){
            int[] binary1 = getBinary(arr1[i], n);
            int[] binary2 = getBinary(arr2[i], n);
            StringBuilder sb = new StringBuilder();
            for(int j=0; j < n; j++){
                if( binary1[j] == 0 && binary2[j] == 0){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    public int[] getBinary(int num, int length){
        int[] binary = new int[length];
        for(int i = length-1; i >= 0; i--){
            int pos = (int) Math.pow(2, i);
            if(num >= pos){
                num -= pos;
                binary[length - i - 1] = 1;
            }
        }
        return binary;
    }
}
