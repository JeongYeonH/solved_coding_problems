package 레벨1_문제;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int endTime = attacks[attacks.length - 1][0];
        
        int sequenced = 0;
        int currAttackIdx = 0;
               
        for(int i = 1; i <= endTime; i++){
            if(attacks[currAttackIdx][0] == i){
                health -= attacks[currAttackIdx][1];
                if(health <= 0){
                    return -1;
                }
                
                sequenced = 0;
                currAttackIdx++;                     
            }else{
                health += bandage[1];
                if (health > maxHealth) health = maxHealth;         
                sequenced++;  
                
                if(sequenced == bandage[0]){
                    health += bandage[2];
                    if (health > maxHealth) health = maxHealth;
                    sequenced = 0;
                }
            }          
        }

        return health;
    }    
}
