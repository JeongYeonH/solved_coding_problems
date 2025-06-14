package 레벨3_문제;

import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> relation = new HashMap<>();
        Map<String, int[]> revenu = new HashMap<>();
        for(int i=0; i < enroll.length; i++){
            String superiorGuy = referral[i].equals("-") ? "center" : referral[i];
            relation.put(enroll[i], superiorGuy);
            revenu.put(enroll[i], new int[]{0, 0});
        }
        revenu.put("center", new int[] {0,0});
        relation.put("center", "-");
    
        for(int i=0; i < seller.length; i++){
            String person = seller[i];
            int profit = amount[i]*100;  
            
            while(!person.equals("-")){                
                int give = profit/10;
                int keep = profit - give;
                revenu.get(person)[1] += keep;
                if (give == 0) break;
                
                String superior = relation.get(person);
                person = superior;
                profit = give;
                
            }
        }

        int[] answer = new int[enroll.length];
        for(int i=0; i < enroll.length; i++){
            int[] total = revenu.get(enroll[i]);
            answer[i] = total[0] + total[1];
        }
        
        return answer;
    }
}
