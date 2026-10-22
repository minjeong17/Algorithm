import java.util.*;

class Solution {
    int n;
    List<Integer>[] adj;
    boolean[] visited;
    List<List<String>> accounts;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        this.accounts = accounts;
        n = accounts.size();

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        Map<String, Integer> emailName = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> ac = accounts.get(i);

            for (int j = 1; j < ac.size(); j++) {
                if (emailName.containsKey(ac.get(j))) {
                    int idx = emailName.get(ac.get(j));
                    adj[idx].add(i);
                    adj[i].add(idx);
                } else {
                    emailName.put(ac.get(j), i);
                }
            }
        }

        List<List<String>> answer = new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<String> ans = new ArrayList<>();
                ans.add(accounts.get(i).get(0));
                ans.addAll(bfs(i));

                answer.add(ans);
            }
        }
 
        return answer;
    }

    public Set<String> bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        Set<String> emails = new TreeSet<>();
        for (int i = 1; i < accounts.get(start).size(); i++) {
            emails.add(accounts.get(start).get(i));
        }

        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : adj[curr]) {
                if (!visited[next]) {
                    visited[next] = true;

                    for (int i = 1; i < accounts.get(next).size(); i++) {
                        emails.add(accounts.get(next).get(i));
                    }

                    q.add(next);
                }
            }
        }

        return emails;
    }
}