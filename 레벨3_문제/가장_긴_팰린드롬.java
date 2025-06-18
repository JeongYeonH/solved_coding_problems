package 레벨3_문제;

public class 가장_긴_팰린드롬 {
    public int solution(String s) {
        int rangeOdd = 0;
        int rangeEven = 0;
        for (int i = 0; i < s.length(); i++) {
            rangeOdd = symmetryOdd(s, i, rangeOdd);
            rangeEven = symmetryEven(s, i, rangeEven);
        }
        
        int answer = Math.max((rangeOdd-1)*2+1, rangeEven*2);
        return answer;
    }

    public int symmetryOdd(String s, int current, int symmetryRange) {
        String left = s.charAt(current) + "";
        String right = s.charAt(current) + "";
        while (true) {
            if (current - symmetryRange < 0) break;
            if (current + symmetryRange >= s.length()) break;

            String sub = s.substring(current - symmetryRange, current + 1);
            left = new StringBuilder(sub).reverse().toString();
            right = s.substring(current, current + symmetryRange + 1);

            if (!left.equals(right)) break;
            symmetryRange++;
        }
        return symmetryRange;
    }

    public int symmetryEven(String s, int current, int symmetryRange) {
        String left = s.charAt(current) + "";
        if(current+1 >= s.length()) return symmetryRange;
        
        String right = s.charAt(current+1) + "";
        while (true) {
            if (current - symmetryRange < 0) break;
            if (current + symmetryRange + 1 >= s.length()) break;

            String sub = s.substring(current - symmetryRange, current + 1);
            left = new StringBuilder(sub).reverse().toString();
            right = s.substring(current+1, current + symmetryRange + 2);

            if (!left.equals(right)) break;
            symmetryRange++;
        }
        return symmetryRange;
    }
}
