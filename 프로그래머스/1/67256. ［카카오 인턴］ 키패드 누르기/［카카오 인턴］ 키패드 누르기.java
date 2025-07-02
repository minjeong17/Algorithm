import java.util.*;

class Solution {
    
    char[][] keypad = {{'1', '2', '3'}, {'4', '5', '6'},
                       {'7', '8', '9'}, {'*', '0', '#'}};
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public class Node {
        char hDir;
        int r;
        int c;
        public Node(char hDir, int r, int c) {
            this.hDir = hDir;
            this.r = r;
            this.c = c;
        }
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        Map<Integer, Node> map = new HashMap<>();
        map.put(1, new Node('L', 0, 0)); map.put(4, new Node('L', 1, 0)); map.put(7, new Node('L', 2, 0));
        map.put(3, new Node('R', 0, 2)); map.put(6, new Node('R', 1, 2)); map.put(9, new Node('R', 2, 2));
        map.put(2, new Node('-', 0, 1)); map.put(5, new Node('-', 1, 1)); map.put(8, new Node('-', 2, 1)); map.put(0, new Node('-', 3, 1));
         
        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};
        
        for (int i = 0; i < numbers.length; i++) {
            Node node = map.get(numbers[i]);
            if (node.hDir != '-') {
                answer.append(node.hDir);
                if (node.hDir == 'L') {
                    leftPos[0] = node.r;
                    leftPos[1] = node.c;
                } else {
                    rightPos[0] = node.r;
                    rightPos[1] = node.c;
                }
                
            } else {
                int leftDir = findDis(leftPos, (char) (numbers[i]+'0'));
                int rightDir = findDis(rightPos, (char) (numbers[i]+'0'));
                
                if (leftDir < rightDir) {
                    answer.append('L');
                    leftPos[0] = node.r;
                    leftPos[1] = node.c;
                } else if (leftDir > rightDir) {
                    answer.append('R');
                    rightPos[0] = node.r;
                    rightPos[1] = node.c;
                } else {
                    if ("left".equals(hand)) {
                        answer.append('L');
                        leftPos[0] = node.r;
                        leftPos[1] = node.c;
                    } else {
                        answer.append('R');
                        rightPos[0] = node.r;
                        rightPos[1] = node.c;
                    }
                }
            }
        }
        
        return answer.toString();
    }
    
    public int findDis(int[] pos, char target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(pos);
        boolean[][] visited = new boolean[4][3];
        visited[pos[0]][pos[1]] = true;
        
        int dis = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                
                if (keypad[curr[0]][curr[1]] == target) return dis;
                
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    
                    if (nr < 0 || nr >= 4 || nc < 0 || nc >= 3) continue;
                    if (visited[nr][nc]) continue;
                    
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
            
            dis++;
        }
        
        return dis;
    }
}