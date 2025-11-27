package 레벨1_문제;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int longerBill = Math.max(bill[0], bill[1]);
        int shorterBill = Math.min(bill[0], bill[1]);
        
        int longerWallet = Math.max(wallet[0], wallet[1]);
        int shorterWallet = Math.min(wallet[0], wallet[1]);
        
        while(true){
            if(longerWallet >= longerBill && shorterWallet >= shorterBill) break;
            
            answer++;
            
            int fold = longerBill / 2;
            longerBill = Math.max(fold, shorterBill);
            shorterBill = Math.min(fold, shorterBill);
        }
        
        return answer;
    }    
}
