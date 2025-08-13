import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        String c1 = br.readLine();
        String c2 = br.readLine();
        String c3 = br.readLine();
        
        Map<String, int[]> map = new HashMap<>();
        map.put("black", new int[] {0, 1}); map.put("brown", new int[] {1, 10});
        map.put("red", new int[] {2, 100}); map.put("orange", new int[] {3, 1000});
        map.put("yellow", new int[] {4, 10000}); map.put("green", new int[] {5, 100000});
        map.put("blue", new int[] {6, 1000000}); map.put("violet", new int[] {7, 10000000});
        map.put("grey", new int[] {8, 100000000}); map.put("white", new int[] {9, 1000000000});
        
        StringBuilder sb = new StringBuilder();
        sb.append(map.get(c1)[0]).append(map.get(c2)[0]);
        
        System.out.println(Long.parseLong(sb.toString()) * map.get(c3)[1]);
    }
}