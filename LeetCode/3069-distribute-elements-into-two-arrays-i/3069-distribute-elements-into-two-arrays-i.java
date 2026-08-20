import java.util.*;

class Solution {
    public int[] resultArray(int[] nums) {
        int[] answer = new int[nums.length];

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);
        int last1 = nums[0];
        int last2 = nums[1];

        for (int i = 2; i < nums.length; i++) {
            if (last1 > last2) {
                arr1.add(nums[i]);
                last1 = nums[i];
            } else {
                arr2.add(nums[i]);
                last2 = nums[i];
            }
        }

        for (int i = 0; i < arr1.size(); i++) {
            answer[i] = arr1.get(i);
        }
        
        for (int i = 0; i < arr2.size(); i++) {
            answer[i + arr1.size()] = arr2.get(i);
        }

        return answer;
    }
}