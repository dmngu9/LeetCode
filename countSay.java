public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            res = generateSeq(res);
        }
        return res;
    }
    
    public String generateSeq (String s) {
        char cursor = s.charAt(0);
        int count = 1;
        String res = "";
        for (int i = 1; i < s.length(); i++) {
            if (cursor != s.charAt(i)) {
                res += String.valueOf(count) + Character.toString(cursor);
                cursor = s.charAt(i);
                count = 1;
                continue;
            }
            count++;
        }
        res += String.valueOf(count) + Character.toString(cursor);
        return res;
    }
}
