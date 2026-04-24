import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int rowNum = relation.length;
        int colNum = relation[0].length;
        
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < (1 << colNum); i++) {
            list.add(i);
        }
        Collections.sort(list, (o1, o2) -> {
            return Integer.bitCount(o1) - Integer.bitCount(o2);
        });
        
        List<Integer> ans = new ArrayList<>();
        Set<String> check = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < ans.size(); j++) {
                if ((list.get(i) & ans.get(j)) == ans.get(j)) {
                    flag = false;
                    break;
                }
            }
            
            if (!flag) continue;
            
            for (String[] r : relation) {
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < colNum; j++) {
                    if ((list.get(i) & (1 << j)) != 0) {
                        tmp.append(r[j]).append("/");
                    }
                }
                check.add(tmp.toString());
            }
            
            if (check.size() == rowNum) ans.add(list.get(i));
            check.clear();
        }
                
        return ans.size();
    }
}