package 레벨3_문제;

import java.util.PriorityQueue;

public class 봉인된_주문 {
    public String solution(long n, String[] bans) {
        PriorityQueue<Long> pQ = new PriorityQueue<>((a, b) -> Long.compare(a, b));
                
        for(int i = 0; i < bans.length; i++){
            long num = fromAlphabetTo10(bans[i]);
            pQ.add(num);
        }
    
        while(!pQ.isEmpty()){
            long num = pQ.poll();
            if(n >= num){
                n++;
            }else{
                break;
            }
        }
        
        return from10toAlphabet(n);
    }
    
    public long fromAlphabetTo10(String s){
        long num = 0;
        
        for(char ch : s.toCharArray()){
            int val = "abcdefghijklmnopqrstuvwxyz".indexOf(ch) + 1;
            num = num * 26 + val;
        }
        
        return num;
    }
    
    public String from10toAlphabet(long num){
        String[] map = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        StringBuilder sb = new StringBuilder();
        
        if(num == 1) return "a";
        
        while(num > 0){
            num--;
            long remainder = num % 26;
            sb.append(map[(int) remainder]);
            num /= 26;
        }
        
        return sb.reverse().toString();
    }
}
