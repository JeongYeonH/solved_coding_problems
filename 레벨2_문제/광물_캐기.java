package 레벨2_문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class 광물_캐기 {
    public int solution(int[] picks, String[] minerals) {
        List<String> temp = new ArrayList<>();
        List<List<String>> all = new ArrayList<>();
        int maxMinerals = Arrays.stream(picks).sum() * 5;
        int limit = Math.min(maxMinerals, minerals.length);

        for(int i = 0; i < limit; i++){
            if(i%5 == 0){
                if(!temp.isEmpty()){
                    all.add(new ArrayList<>(temp));
                    temp.clear();
                }
                temp.add(minerals[i]);
            }else{
                temp.add(minerals[i]);
            }
        }
        
        if(!temp.isEmpty()){
            all.add(new ArrayList<>(temp));
        }
        
        Map<String, Integer> valueMap = Map.of(
            "diamond", 25,
            "iron", 5,
            "stone", 1
        );
        
        all.sort((list1, list2) -> {
            int sum1 = list1.stream().mapToInt(s -> valueMap.get(s)).sum();
            int sum2 = list2.stream().mapToInt(s -> valueMap.get(s)).sum();
            return Integer.compare(sum2, sum1);
        });
        
        List<Integer> pickers = new ArrayList<>();
        for(int i = 0; i < picks.length; i++){
            for(int j = 0; j < picks[i]; j++){
                pickers.add(i);
            }
        }
        
        Map<Integer, int[]> mining = Map.of(
            0, new int[] {1, 1, 1},
            1, new int[] {5, 1, 1},
            2, new int[] {25, 5, 1}
        );
        
        Map<String, Integer> idx = Map.of(
            "diamond", 0,
            "iron", 1,
            "stone", 2
        );
        
        int totalFatigue = 0;
        
        for(int i = 0; i < pickers.size(); i++){
            if(i == all.size()) break;
            int pickaxeType = pickers.get(i);
            int fatigue = all.get(i).stream()
                                    .mapToInt(s -> mining.get(pickaxeType)[idx.get(s)])
                                    .sum();
            totalFatigue += fatigue;
        }
        return totalFatigue;
    }
}
