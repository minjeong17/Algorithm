import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<char[], List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);

            boolean isAnag = false;
            for (char[] k : map.keySet()) {
                if (k.length != tmp.length) continue;

                boolean flag = true;
                for (int i = 0; i < k.length; i++) {
                    if (k[i] != tmp[i]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    map.get(k).add(str);
                    isAnag = true;
                    break;
                }
            }

            if (!isAnag) {
                map.put(tmp, new ArrayList<>());
                map.get(tmp).add(str);
            }

        }

        List<List<String>> answer = new ArrayList<>();
        int idx = 0;
        for (char[] c : map.keySet()) {
            answer.add(new ArrayList<>());

            for (String s : map.get(c)) {
                answer.get(idx).add(s);
            }

            idx++;
        }

        return answer;
    }
}