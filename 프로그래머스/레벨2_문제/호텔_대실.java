package 레벨2_문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 호텔_대실 {
    public int solution(String[][] book_time) {
        int[][] min_time = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++){
            String[] time = book_time[i];             
            min_time[i] = Arrays.stream(time).mapToInt(t -> convertToMins(t)).toArray();
        }
        
        Arrays.sort(min_time , (a,b) -> {
            int timeA = a[0];
            int timeB = b[0];
            return Integer.compare(timeA, timeB);
        });
        
        List<List<Integer>> total_rooms = new ArrayList<>();
        List<Integer> room = new ArrayList<>();
        room.add(min_time[0][1]);
        total_rooms.add(room);
        
        for(int i = 1; i < min_time.length; i++){
            int start = min_time[i][0];
            int end = min_time[i][1];
            boolean ableToFit = false;
            
            for(int j = 0; j < total_rooms.size(); j++){
                List<Integer> currRoom = total_rooms.get(j);
                int lastEnd = currRoom.get(currRoom.size() - 1);
                
                if(start >= lastEnd + 10){
                    ableToFit = true;
                    currRoom.add(end);
                    break;
                }
            }
            if(!ableToFit){
                List<Integer> newRoom = new ArrayList<>(List.of(end));
                total_rooms.add(newRoom);
            }
        }     
        
        return total_rooms.size();
    }
    
    public int convertToMins(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
    }
}
