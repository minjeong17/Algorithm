import java.util.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;

        int left = 0;
        int right = people.length - 1;
        while (left < right) {
            if (people[right] >= limit) {
                answer++;
                right--;
            } else {
                if (people[left] + people[right] > limit) {
                    answer++;
                    right--;
                } else {
                    answer++;
                    left++;
                    right--;
                }
            }
        }

        if (left == right) answer++;

        return answer;
    }
}