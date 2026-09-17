import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] best = new int[n];
        int minLen = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;

        int left = 0;
        int sum = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int currLen = right - left + 1;

                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    answer = Math.min(
                        answer,
                        currLen + best[left - 1]
                    );
                }

                minLen = Math.min(minLen, currLen);
            }

            best[right] = minLen;
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}