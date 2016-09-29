import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            System.out.println(possibility(n,map));
        }     
    }
    
    private static int possibility(int n, HashMap<Integer, Integer> map) {
        if (n == 0)
            return 1;
        if (map.containsKey(n))
            return map.get(n);
        
        int sum = 0;
        for (int i = 1; i < 4; i++) {
            if (n >= i) {
                sum += possibility(n-i, map);
            }
        }
        map.put(n,sum);
        return sum;
    }
}