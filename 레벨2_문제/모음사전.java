package 레벨2_문제;

public class 모음사전 {
    class Solution {
        int index = 0;
        int answer = 0;
        String[] vowels = {"A", "E", "I", "O", "U"};
        public int solution(String word) {
            dfs("", word);
            return answer;
        }
        
        public void dfs(String current, String target){
            if(current.equals(target)){
                answer = index;
                return;
            }
            
            if(current.length() >= 5) return;
            
            for(int i = 0; i < 5; i++){
                index++;
                dfs(current + vowels[i], target);
            }
        }
    }
}
