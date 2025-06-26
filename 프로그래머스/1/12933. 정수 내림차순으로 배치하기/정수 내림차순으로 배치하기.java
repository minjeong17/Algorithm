import java.util.*;

class Solution {
    public long solution(long n) {
        
        char[] nums = String.valueOf(n).toCharArray();
        Arrays.sort(nums);
        
        StringBuilder sb = new StringBuilder();
        for (int i = nums.length-1; i >= 0; i--) {
            sb.append(nums[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}