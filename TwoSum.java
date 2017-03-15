public class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> complement = new HashMap<>();
        int[] res = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            int offset = target - nums[i];
            if (!complement.containsKey(nums[i])) {
                complement.put(offset, i);
            } else {
                res[0] = complement.get(nums[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
