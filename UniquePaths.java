//https://leetcode.com/problems/unique-paths/

public class Solution {
    
    private HashMap<ArrayList<Integer>, Integer> map = new HashMap<ArrayList<Integer>, Integer>();
    
    public int uniquePaths(int m, int n) {
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(m);
        list.add(n);
        
        if (map.containsKey(list))
            return map.get(list);
        if (m == 1 && n == 1)
            return 1;
        
        int noOfPathsRight = 0;
        int noOfPathsDown = 0;
        if (n > 1)
            noOfPathsRight = uniquePaths(m, n-1);
        if (m > 1)
            noOfPathsDown = uniquePaths(m - 1, n);
            
        int noOfPaths = noOfPathsRight + noOfPathsDown;
        map.put(list, noOfPaths);
        return noOfPaths;
    }
}