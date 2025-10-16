package 레벨2_문제;

import java.util.*;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> q = new LinkedList<>();
        List<Integer> passed_trucks = new ArrayList<>();

        int idx = 0;
        int time = 0;
        int total_weights = 0;
        
        while(true){
            time++;
            
            if(!q.isEmpty()){
                int recent_truck_time = q.peek()[0];
            
                if(time >= bridge_length + recent_truck_time){
                    int[] out_truck = q.poll();
                    total_weights -= out_truck[1];
                    passed_trucks.add(out_truck[1]);
                }
            }
            
            if(idx < truck_weights.length){
                if(total_weights + truck_weights[idx] <= weight){
                    q.add(new int[]{time, truck_weights[idx]});
                    total_weights += truck_weights[idx];
                    idx++;
                }
            }

                        
            if(passed_trucks.size() >= truck_weights.length) break;
        }
        
        return time;
    }
}
