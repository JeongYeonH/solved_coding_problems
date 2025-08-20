package 레벨2_문제;

public class 문자열_압축 {
    public int solution(String s) {
        int answer = s.length();
        int totalLength = s.length();

        for (int interval = 1; interval <= totalLength / 2; interval++) {
            String previous = s.substring(0, interval);
            int currMinLength = 0;
            int repeatCounting = 1;

            for (int j = interval; j < totalLength; j += interval) {
                int endIndex = Math.min(j + interval, totalLength);
                String part = s.substring(j, endIndex);

                if (previous.equals(part)) {
                    repeatCounting++;
                } else {
                    if (repeatCounting > 1) {
                        currMinLength += String.valueOf(repeatCounting).length();
                    }
                    currMinLength += previous.length();
                    previous = part;
                    repeatCounting = 1;
                }
            }

            if (repeatCounting > 1) {
                currMinLength += String.valueOf(repeatCounting).length();
            }
            currMinLength += previous.length();
            answer = Math.min(answer, currMinLength);
        }
        return answer;
    }
}
