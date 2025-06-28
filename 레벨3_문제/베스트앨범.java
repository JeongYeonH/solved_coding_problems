package 레벨3_문제;

import java.util.*;

public class 베스트앨범 {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        Map<String, Map<Integer, Integer>> genreMap = new HashMap<>();
        for(int i=0; i < genres.length; i++){
            String genre = genres[i];
            int playedTime = plays[i];
            if(genreMap.containsKey(genre)){
                Map<Integer, Integer> songMap = genreMap.get(genre);
                int totalPlayedTime = songMap.get(-1);
                songMap.put(-1, totalPlayedTime+playedTime);
                songMap.put(i, playedTime);
                
            }else{
                Map<Integer, Integer> songs = new HashMap<>();
                songs.put(-1, playedTime);
                songs.put(i, playedTime);
                genreMap.put(genre, songs);
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        List<Map.Entry<String, Map<Integer, Integer>>> sortedGenres = new ArrayList<>(genreMap.entrySet());
        sortedGenres.sort((a,b) -> {
            Integer valueA = a.getValue().get(-1);
            Integer valueB = b.getValue().get(-1);
            return valueB - valueA;
        });
        
        for(Map.Entry<String, Map<Integer, Integer>> entry : sortedGenres){
            List<Map.Entry<Integer, Integer>> sortedPlays = new ArrayList<>(entry.getValue().entrySet());
            sortedPlays.sort((a,b)-> {
                Integer valA = a.getValue();
                Integer valB = b.getValue();
                return valB - valA;
            });
            
            for(int i=1; i < sortedPlays.size(); i++){
                if(i >= 3) break;
                int idx = sortedPlays.get(i).getKey();
                answer.add(idx);
            }
        }       
        return answer;
    }
}
