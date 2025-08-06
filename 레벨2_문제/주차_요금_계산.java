package 레벨2_문제;

import java.util.*;

public class 주차_요금_계산 {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, int[]> map = new HashMap<>();
        
        for(int i = 0; i < records.length; i++){
            String[] record = records[i].split(" ");
            String[] time = record[0].split(":");
            int mins = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);       
            String carNum = record[1];
            String act = record[2];
            
            if(act.equals("IN")){
                if(map.containsKey(carNum)){
                    int[] infos = map.get(carNum);
                    map.put(carNum, new int[] {infos[0], mins});
                }else{
                    map.put(carNum, new int[] {0, mins});
                }                           
            }else if(act.equals("OUT")){
                int[] infos = map.get(carNum);
                int usedTime = mins - infos[1];
                infos[0] += usedTime;
                infos[1] = -999;
                map.put(carNum, infos);
            }
        }
        int[] answer = new int[map.size()];
        int idx = 0;
        Map<String, int[]> sortedByKey = new TreeMap<>(map);
        for(Map.Entry<String, int[]> m : sortedByKey.entrySet()){
            String key = m.getKey();
            int[] infos = m.getValue();
            if(infos[1] != -999){
                int addTime = 1439 - infos[1];
                infos[0] += addTime;
            }
            map.put(key, infos);
            System.out.println(key + "-" + Arrays.toString(infos));
            
            int totalTime = infos[0];
            double amt = (totalTime-fees[0])/(double)fees[2];
            int amount = (int) Math.ceil(amt);
            int totalFee = totalTime <= fees[0] ? fees[1] : amount*fees[3] + fees[1];
            answer[idx] = totalFee;
            idx++;
        }
        return answer;
    }
}
