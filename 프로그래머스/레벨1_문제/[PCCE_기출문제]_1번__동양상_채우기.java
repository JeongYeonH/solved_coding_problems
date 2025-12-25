package 레벨1_문제;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] vLen = video_len.split(":");
        String[] pLen = pos.split(":");
        String[] sLen = op_start.split(":");
        String[] eLen = op_end.split(":");
        
        int videoLen = Integer.parseInt(vLen[1]) + Integer.parseInt(vLen[0]) * 60;
        int posLen = Integer.parseInt(pLen[1]) + Integer.parseInt(pLen[0]) * 60;
        int startLen = Integer.parseInt(sLen[1]) + Integer.parseInt(sLen[0]) * 60;
        int endLen = Integer.parseInt(eLen[1]) + Integer.parseInt(eLen[0]) * 60;
        
        int currSec = posLen;
        
        for(int i = 0; i < commands.length; i++){
            if(currSec <= endLen && currSec >= startLen){
                currSec = endLen;
            }
            
            String command = commands[i];         
            switch(command){
                case "next":
                    currSec = videoLen - currSec < 10 ? videoLen : currSec + 10;
                    break;
                case "prev":
                    currSec = currSec < 10 ? 0 : currSec - 10;
                    break;
                default:
                    break;
            }
        }
        
        if(currSec <= endLen && currSec >= startLen){
            currSec = endLen;
        }
        
        int hours = currSec / 60;
        int mins = currSec % 60;
        
        String answer = String.format("%02d", hours) + ":" + String.format("%02d", mins);
        return answer;
    }
}