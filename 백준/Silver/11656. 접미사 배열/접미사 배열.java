import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        String[] arr = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.substring(i);
        }

        Arrays.sort(arr, (o1, o2) -> {
            for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                if (o1.charAt(i) != o2.charAt(i)) {
                    return o1.charAt(i) - o2.charAt(i);
                }
            }

            return o1.length() - o2.length();
        });

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            ans.append(arr[i]).append("\n");
        }

        System.out.println(ans);
    }
}
