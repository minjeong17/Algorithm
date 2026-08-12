import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.length; i++) {
                sb.append(tmp[i]);
            }
        
            String sorted = sb.toString();
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }

        List<List<String>> answer = new ArrayList<>();
        int idx = 0;
        for (String c : map.keySet()) {
            answer.add(new ArrayList<>());

            for (String s : map.get(c)) {
                answer.get(idx).add(s);
            }

            idx++;
        }

        return answer;
    }
}