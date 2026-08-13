import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cntMap.put(nums[i], cntMap.getOrDefault(nums[i], 0) + 1);
        }

        List<List<Integer>> answer = new ArrayList<>();
        if (cntMap.size() == 1) {
            for (int k : cntMap.keySet()) {
                if (k == 0) {
                    answer.add(new ArrayList<>());
                    answer.get(0).add(0);
                    answer.get(0).add(0);
                    answer.get(0).add(0);

                    return answer;
                } else return answer;
            }
        }
        
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = (-1) * nums[i];
            cntMap.put(nums[i], cntMap.get(nums[i]) - 1);
            for (int j = i+1; j < nums.length; j++) {
                rem -= nums[j];
                cntMap.put(nums[j], cntMap.get(nums[j]) - 1);

                if (cntMap.containsKey(rem) && cntMap.get(rem) > 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]); tmp.add(nums[j]); tmp.add(rem);
                    Collections.sort(tmp);
                    set.add(tmp);
                }

                rem += nums[j];
                cntMap.put(nums[j], cntMap.get(nums[j]) + 1);
            }

            cntMap.put(nums[i], cntMap.get(nums[i]) + 1);
        }

        for (List<Integer> l : set) {
            answer.add(l);
        }

        return answer;
    }
}