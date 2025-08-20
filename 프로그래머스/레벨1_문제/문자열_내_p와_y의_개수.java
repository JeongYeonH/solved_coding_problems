package 레벨1_문제;

public class 문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        boolean answer = true;
        int ans = 0;
        for(int i=0; i <s.length(); i++){
            String alphabet = s.substring(i, i+1);
            if( alphabet.equals("p") || alphabet.equals("P")){
                ans++;
            }else if(alphabet.equals("y") || alphabet.equals("Y")){
                ans--;
            }
        }
        if(ans != 0){
            answer = false;
        }
        return answer;
    }
}
