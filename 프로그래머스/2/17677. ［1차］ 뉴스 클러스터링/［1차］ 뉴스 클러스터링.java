import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length()-1; i++) {
            sb.append(str1.charAt(i)).append(str1.charAt(i+1));
            if (sb.toString().matches("^[a-zA-Z]+$"))
                list1.add(sb.toString().toLowerCase());
            
            sb.setLength(0);
        }
        for (int i = 0; i < str2.length()-1; i++) {
            sb.append(str2.charAt(i)).append(str2.charAt(i+1));
            if (sb.toString().matches("^[a-zA-Z]+$"))
                list2.add(sb.toString().toLowerCase());
            
            sb.setLength(0);
        }
        
        if (list1.size() == 0 && list2.size() == 0) return 65536;
        
        int intersection = 0;
        List<String> list1Tmp = new ArrayList<>(list1);
        for (String s : list2) {
            if (list1Tmp.contains(s)) {
                intersection++;
                list1Tmp.remove(s);
            }
        }
        
        int union = list1.size() + list2.size() - intersection;
        
        
        return intersection * 65536 / union;
        
    }
}