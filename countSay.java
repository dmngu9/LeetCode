public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            int count = 0;
            char marker = res.charAt(0);
            String temp = "";
            for (char c : res.toCharArray()) {
                if (marker == c) {
                    count++;
                } else {
                    temp += Integer.toString(count) + Character.toString(marker);
                    count = 1;
                }
                marker = c;
            }
            temp += Integer.toString(count) + Character.toString(marker);
            res = temp;
        }
        return res;
    }
}
