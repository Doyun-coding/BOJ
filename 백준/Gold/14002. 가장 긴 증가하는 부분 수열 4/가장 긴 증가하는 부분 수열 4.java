import java.io.*;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[] arr;
    static int[][] dp;
    static int[] parent;
    static int m;
    static int index;
    static Stack<Integer> stack;

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[y] = x;
        }
    }

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        dp = new int[2][N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }

        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        if(N == 1) {
            bw.write("1\n");
            bw.write(arr[1] + "\n");
        }
        else {
            dp[0][1] = 1;
            for (int i = 2; i <= N; i++) {
                int max = 0;
                int pre = -1;
                for (int j = 1; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        if (dp[0][j] >= max) {
                            max = dp[0][j];
                            pre = j;
                        }
                    }
                }

                dp[0][i] = max + 1;
                dp[1][i] = pre;
                if (dp[0][i] > m) {
                    m = dp[0][i];
                    index = i;
                }
            }

            bw.write(m + "\n");

            stack = new Stack<>();
            for (int i = N; i >= 1; i--) {
                if (i == index) {
                    stack.add(arr[i]);
                    index = dp[1][i];
                }
            }

            while (!stack.isEmpty()) {
                bw.write(stack.pop() + " ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
