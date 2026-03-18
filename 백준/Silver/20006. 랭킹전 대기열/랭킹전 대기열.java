import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<String>> rooms = new ArrayList<>();
        Map<String, Integer> levels = new HashMap<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            
            levels.put(n, l);
            boolean getIn = false;
            int size = rooms.size();
            for (int j = 0; j < size; j++) {
                if (rooms.get(j).size() == m) continue;
                String f = rooms.get(j).get(0);
                int roomLv = levels.get(f);
                if (l <= roomLv + 10 && l >= roomLv - 10) {
                    rooms.get(j).add(n);
                    getIn = true;
                    break;
                }
            }
            
            if (!getIn) {
                rooms.add(new ArrayList<>());
                rooms.get(rooms.size()-1).add(n);
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < rooms.size(); i++) {
            int size = rooms.get(i).size();
            if (size == m) {
                ans.append("Started!").append("\n");
            } else {
                ans.append("Waiting!").append("\n");
            }
            
            String[] tmp = new String[size];
            for (int j = 0; j < size; j++) {
                tmp[j] = rooms.get(i).get(j);
            }
            Arrays.sort(tmp);
            for (int j = 0; j < size; j++) {
                ans.append(levels.get(tmp[j])).append(" ").append(tmp[j]).append("\n");
            }
        }
        
        System.out.println(ans.toString());
    }
}