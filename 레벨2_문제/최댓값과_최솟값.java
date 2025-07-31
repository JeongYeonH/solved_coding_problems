package 레벨2_문제;

import java.util.Arrays;

public class 최댓값과_최솟값 {
    public String solution(String s) {
        String[] str = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] strInt = Arrays.stream(str).mapToInt(e -> Integer.parseInt(e)).toArray();
        for(int i = 0; i < strInt.length; i++){
            int num = strInt[i];
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(min));
        sb.append(" ");
        sb.append(Integer.toString(max));
        return sb.toString();
    }
}
