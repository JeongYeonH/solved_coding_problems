package 레벨2_문제;

import java.util.*;

public class 오픈채팅방 {
        public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for(String str : record){
            String[] infos = str.split(" ");
            String keyword = infos[0];
            
            if(keyword.equals("Leave")) continue;
            
            String uid = infos[1];    
            String nickName = infos[2];
            
            map.put(uid, nickName);
        }
        
        for(String str : record){
            String[] infos = str.split(" ");
            String keyword = infos[0];
            String uid = infos[1];
            String nickName = map.get(uid);
            
            if(keyword.equals("Change")) continue;
            
            if(keyword.equals("Enter")){
                answer.add(nickName + "님이 들어왔습니다.");
            }else if(keyword.equals("Leave")){
                answer.add(nickName + "님이 나갔습니다.");
            }
                
        }
        return answer;
    }
}
