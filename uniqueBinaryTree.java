public class Solution {
    
    private HashMap<Integer, Integer> map = new HashMap<>();
    
    public int numTrees(int n) {
        map.put(0,1);
        for (int i = 1; i <= n ; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                int left = j - 1;
                int right = i - j;
                sum += map.get(left) * map.get(right);
            }
            map.put(i, sum);
        }
        int res = map.get(n);
        return res;
    }
}