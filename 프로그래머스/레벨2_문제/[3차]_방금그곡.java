package 레벨2_문제;

import java.util.*;
import java.util.regex.*;

class Solution{
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;


        List<String> Mnotes = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-G]#?");
        Matcher mt2 = pattern.matcher(m);
        
        while (mt2.find()) {
            Mnotes.add(mt2.group());
        }

        for (String info : musicinfos) {
            String[] arr = info.split(",");
            String title = arr[2];
            String score = arr[3];


            String[] beginTime = arr[0].split(":");
            String[] endTime = arr[1].split(":");
            int beginSec = Integer.parseInt(beginTime[0]) * 60 + Integer.parseInt(beginTime[1]);
            int endSec = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
            int totalSec = endSec - beginSec;
       
            List<String> notes = new ArrayList<>();
            Matcher mt = pattern.matcher(score);
            
            while (mt.find()) {
                notes.add(mt.group());
            }
           
            List<String> played = new ArrayList<>();
            
            for (int i = 0; i < totalSec; i++) {
                played.add(notes.get(i % notes.size()));
            }

            for (int i = 0; i <= played.size() - Mnotes.size(); i++) {
                boolean match = true;
                
                for (int j = 0; j < Mnotes.size(); j++) {
                    if (!played.get(i + j).equals(Mnotes.get(j))) {
                        match = false;
                        break;
                    }
                }
                
                if (match && totalSec > maxTime) {
                    answer = title;
                    maxTime = totalSec;
                    break;
                }
            }
        }

        return answer;
    }
}
