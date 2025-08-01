package 레벨2_문제;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int max = yellow < 3 ? 2 : yellow/2;
        
        for(int i = 1; i <= max; i++){
            if(yellow%i == 0){
                int row = i; 
                int col = yellow/i;
                int brownCandidate = row*2 + col*2 + 4;
                if(brown == brownCandidate){
                    return new int[] {col+2, row+2};
                }

            }
        }
        return answer;
    }
}
