import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();

        int[][] alphaIdx = new int[26][2]; // [minIdx, maxIdx]
        for (int i = 0; i < 26; i++) {
            alphaIdx[i][0] = -1;
            alphaIdx[i][1] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (alphaIdx[idx][0] == -1) {
                alphaIdx[idx][0] = i;
            }

            alphaIdx[idx][1] = i;
        }

        Arrays.sort(alphaIdx, (o1, o2) -> o1[0] - o2[0]);
        
        int minIdx = -1;
        int maxIdx = -1;
        for (int i = 0; i < alphaIdx.length; i++) {
            int a = alphaIdx[i][0];
            int b = alphaIdx[i][1];

            if (a == -1) continue;

            if (a > maxIdx) {
                if (maxIdx != -1) answer.add(maxIdx - minIdx + 1);
                minIdx = a;
                maxIdx = b;
            } else {
                if (maxIdx < b) maxIdx = b;
            }
        }

        answer.add(maxIdx - minIdx + 1);

        return answer;
    }
}