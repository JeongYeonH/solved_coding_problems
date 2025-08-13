package 레벨2_문제;

public class 피로도 {
    int depths = 0;
    int maxDepths = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        search(k, dungeons, visited);
        
        return maxDepths;
    }
    
    public void search(int health, int[][] dungeons, boolean[] visited){     
        for(int i = 0; i < dungeons.length; i++){
            int required = dungeons[i][0];
            int used = dungeons[i][1];
            if(health < required || visited[i]) continue;
            health -= used;
            visited[i] = true;
            depths++;
            maxDepths = Math.max(depths, maxDepths);
            
            search(health, dungeons, visited);            
            
            health += used;
            visited[i] = false;
            depths--;
        }
    }
}
