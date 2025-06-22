import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int lastNode;
    static char[] tree;
    static StringBuilder pre, in, post;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);

        lastNode = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left != '.') {
                map.put(left, map.get(root)*2);
                lastNode = Math.max(lastNode, map.get(left));
            }
            if (right != '.') {
                map.put(right, map.get(root)*2+1);
                lastNode = Math.max(lastNode, map.get(right));
            }
        }

        tree = new char[lastNode+1];
        for (char node : map.keySet()) {
            tree[map.get(node)] = node;
        }

        pre = new StringBuilder();
        preOrder(1);

        in = new StringBuilder();
        inOrder(1);

        post = new StringBuilder();
        postOrder(1);

        System.out.println(pre + "\n" + in + "\n" + post);
    }

    private static void postOrder(int v) {
        if (v <= lastNode) {
            postOrder(v*2);
            postOrder(v*2+1);
            if (tree[v] != '\u0000') {
                post.append(tree[v]);
            }
        }
    }

    private static void inOrder(int v) {
        if (v <= lastNode) {
            inOrder(v*2);
            if (tree[v] != '\u0000') {
                in.append(tree[v]);
            }
            inOrder(v*2+1);
        }
    }

    private static void preOrder(int v) {
        if (v <= lastNode) {
            if (tree[v] != '\u0000') {
                pre.append(tree[v]);
            }
            preOrder(v*2);
            preOrder(v*2+1);
        }
    }
}
