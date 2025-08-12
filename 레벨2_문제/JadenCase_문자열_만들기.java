package 레벨2_문제;

public class JadenCase_문자열_만들기 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(i, i + 1);
            if(i > 0 && s.substring(i-1, i).equals(" ") && s.substring(i, i+1).matches("^[a-zA-Z]*$")){
                answer.append(str.toUpperCase());
            }else if(i==0 && s.substring(i, i+1).matches("^[a-zA-Z]*$")){
                answer.append(str.toUpperCase());
            }else{
                answer.append(str.toLowerCase());
            }
        }
        
        return answer.toString();
    }
}
