package 레벨4_문제;

import java.util.*;

public class 단어_퍼즐 {
    public int solution(String[] strs, String t) {
        Set<String> set = new HashSet<>();
        int[] ts = new int[t.length()];
        Arrays.fill(ts, 200001);
        int maxLength = 0;
        
        for(String str : strs){
            set.add(str);
            maxLength = Math.max(maxLength, str.length());
        }

        for(int i = 0; i < ts.length; i++){
            int lowest = i - maxLength < 0 ? 0 : i - maxLength;
            for(int j = i; j >= lowest; j--){
                String candidate = t.substring(j, i+1);
                if(set.contains(candidate)){
                    if(j-1 >= 0){
                        if(ts[j-1] != 200001){
                            ts[i] = Math.min(ts[i], ts[j-1] + 1);
                        }
                    }else{
                        ts[i] = Math.min(ts[i], 1);
                    }
                }
            }
        }
        return ts[ts.length-1] == 200001 ? -1 : ts[ts.length-1];
    }
}
