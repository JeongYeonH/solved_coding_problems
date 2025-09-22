package 레벨3_문제;

public class _110_옮기기 {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for(int i = 0; i < s.length; i++){
            StringBuilder sb = new StringBuilder();
            char[] chars = s[i].toCharArray();
            int numsOf001 = 0;
            
            for(int j = 0; j < chars.length; j++){
                char c = chars[j];
                sb.append(c);
                
                int length = sb.length();
                                
                if(length >= 3){
                    char thd = sb.charAt(length - 1);
                    char sec = sb.charAt(length - 2);
                    char fst = sb.charAt(length - 3);
                    
                    if(fst == '1' && sec == '1' && thd == '0'){
                        sb.setLength(length - 3);
                        numsOf001 += 1;
                    }
                }
            }
            
            int index = sb.lastIndexOf("0");
            sb.insert(index + 1, "110".repeat(numsOf001));
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}
