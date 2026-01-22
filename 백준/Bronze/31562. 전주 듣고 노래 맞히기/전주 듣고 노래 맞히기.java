import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder ans = new StringBuilder();
        
        Map<String, List<String>> songs = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int T = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            StringBuilder song = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                song.append(st.nextToken());
            }
            for (int j = 0; j < 4; j++) st.nextToken();
            
            String songStr = song.toString();
            if (songs.containsKey(songStr)) {
                songs.get(songStr).add(S);
            } else {
                List<String> l = new ArrayList<>();
                l.add(S);
                songs.put(songStr, l);
            }
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            StringBuilder melody = new StringBuilder();
            for (int j = 0; j < 3; j++) melody.append(st.nextToken());
            
            String melStr = melody.toString();
            if (songs.containsKey(melStr)) {
                if (songs.get(melStr).size() == 1) {
                    ans.append(songs.get(melStr).get(0)).append("\n");
                } else {
                    ans.append("?").append("\n");
                }
            } else {
                ans.append("!").append("\n");
            }
            
        }
        
        System.out.println(ans);
    }
}