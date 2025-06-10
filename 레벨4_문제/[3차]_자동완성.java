import java.util.*;

class Solution {
    public int solution(String[] words) {
        List<TreeNode> roots = new ArrayList<>();
        Arrays.sort(words); 
        
        String tempChar = "";
        TreeNode lastNode = null;
        for(int j=0; j < words.length; j++){
            String cha = Character.toString(words[j].charAt(0));                 
            if(!tempChar.equals(cha)){
                tempChar = cha;
                TreeNode node = new TreeNode(tempChar, new int[]{j, words.length-1});
                roots.add(node);
                if(lastNode != null){
                    lastNode.coverRange[1] = j-1;
                }
                lastNode = node;
            }
        }
        
        String answerWords = "";
        for (TreeNode root : roots){
            answerWords += bfsMechanic(root, words);
        }
        return answerWords.length();
    }
    
    public String bfsMechanic(TreeNode root, String[] words){
        Queue<TreeNode> queue = new LinkedList<>();
        int currentLevelSize = 0;
        int currentLevel = 1;
        String detachedWords = "";
        queue.add(root);
        
        while(queue.size() >0){
            currentLevelSize = queue.size();
            while(currentLevelSize-- != 0){ 
                TreeNode curr = queue.poll();  
                if(curr.coverRange[0] == curr.coverRange[1] ){
                    detachedWords+=curr.value;
                    continue;
                }
                if(curr.value.length() == words[curr.coverRange[0]].length()){
                    detachedWords+=curr.value;
                }
                String tempChar = "";
                TreeNode lastNode = null;
                for(int i = curr.coverRange[0]; i <= curr.coverRange[1]; i++){
                    if(currentLevel >= words[i].length()) continue;
                    String cha = Character.toString(words[i].charAt(currentLevel));
                    if(!tempChar.equals(cha)){
                        tempChar = cha;
                        String character = curr.value + tempChar;
                        TreeNode node = new TreeNode(character, new int[]{i, curr.coverRange[1]});
                        curr.addChild(node);
                        if(lastNode != null){
                            lastNode.coverRange[1] = i-1;
                        }
                        lastNode = node;
                        queue.add(node);
                    }                                        
                }
            }
            currentLevel++;
        }       
        return detachedWords;
    }
}

class TreeNode{
    String value;
    int[] coverRange;
    List<TreeNode> children;
    
    public TreeNode(String value, int[] coverRange){
        this.value = value;
        this.coverRange = coverRange;
        this.children = new ArrayList<>();
    }
    
    public void addChild(TreeNode child){
        this.children.add(child);
    }
}