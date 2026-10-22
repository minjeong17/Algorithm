import java.util.*;

class Solution {
    int numCourses;
    int[] preCnt;
    List<Integer>[] adj;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;

        preCnt = new int[numCourses];
        adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) adj[i] = new ArrayList<>();

        for (int[] pre : prerequisites) {
            if (pre[0] == pre[1]) return false;

            preCnt[pre[0]]++;
            adj[pre[1]].add(pre[0]);
        }

        return bfs();
    }

    public boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < preCnt.length; i++) {
            if (preCnt[i] == 0) q.add(i);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int n : adj[curr]) {
                preCnt[n]--;

                if (preCnt[n] == 0) q.add(n);
            }

            cnt++;
        }

        return cnt == numCourses;
    }
}