import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> cntPlay = new HashMap<>();
        Map<String, PriorityQueue> cntRank = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            cntPlay.put(genres[i], cntPlay.getOrDefault(genres[i], 0) + plays[i]);
            if (cntRank.containsKey(genres[i])) {
                cntRank.get(genres[i]).add(new int[] {i, plays[i]});
            } else {
                PriorityQueue<int[]> tmp = new PriorityQueue<>((o1, o2) -> {
                    if (o2[1] == o1[1]) return o1[0] - o2[0];
                    return o2[1] - o1[1];
                });
                tmp.add(new int[] {i, plays[i]});
                cntRank.put(genres[i], tmp);
            }
        }
        
        List<String> genreSorted = new ArrayList<>(cntPlay.keySet());
        genreSorted.sort((a, b) -> cntPlay.get(b) - cntPlay.get(a)); 
        
        List<Integer> ans = new ArrayList<>();
        for (String g : genreSorted) {
            PriorityQueue<int[]> t = cntRank.get(g);
            for (int i = 0; i < 2; i++) {
                int[] tt = t.poll();
                ans.add(tt[0]);
                if (t.isEmpty()) break;
            }
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
            
        return answer;
    }
}