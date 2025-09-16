package 레벨3_문제;

public class 미로_탈출_명령어 {
    boolean found = false;
    String answer;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int row = n;
        int col = m;
        
        int[] start = new int[]{x, y};
        int[] end = new int[]{r, c};
        
        StringBuilder sb = new StringBuilder();
        dfs(row, col, start, end, k, 0, sb);

        return answer != null ? answer : "impossible";
    }
    
    public void dfs(int row, int col, int[] curr, int[] end, int k, int count, StringBuilder sb){
        if(found) return;
        
        if(count >= k){
            if(curr[0] == end[0] && curr[1] == end[1]){
                found = true;
                answer = sb.toString();
                return;
                
            }
            return;
        }
        
        int[] dy = new int[]{1, 0, 0, -1};
        int[] dx = new int[]{0, -1, 1, 0};
        String[] dirr = new String[]{"d", "l", "r", "u"};
        
        for(int i = 0; i < 4; i++){            
            int newY = curr[0] + dy[i];
            int newX = curr[1] + dx[i];
            
            if(newY < 1 || newY > row || newX < 1 || newX > col) continue;
            
            int dist = Math.abs(newY - end[0]) + Math.abs(newX - end[1]);
            
            if(dist > k - (count + 1)) continue;
            if((k - (count + 1) - dist) % 2 != 0) continue;
                      
            sb.append(dirr[i]);
            dfs(row, col, new int[]{newY, newX}, end, k, count + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
