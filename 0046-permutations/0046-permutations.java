import java.util.*;

class Solution {
    int[] nums;
    List<List<Integer>> answer;
    boolean[] visited;
    int[] sel;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        answer = new ArrayList<>();

        sel = new int[nums.length];
        visited = new boolean[nums.length];
        perm(0);

        return answer;
    }

    public void perm(int idx) {
        if (idx == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < sel.length; i++) {
                tmp.add(sel[i]);
            }

            answer.add(tmp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sel[idx] = nums[i];
                perm(idx + 1);
                visited[i] = false;
            }
        }
    }
}