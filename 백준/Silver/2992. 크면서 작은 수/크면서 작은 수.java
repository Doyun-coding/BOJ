import java.util.*;
import java.io.*;
public class Main {
    static int N, num, min = Integer.MAX_VALUE;
    static int[] arr, list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        num = Integer.parseInt(s);
        N = s.split("").length;
        arr = new int[N];
        list = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s.split("")[i]);
        }
        BT(0);
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);

    }
    public static void BT(int depth) {
        if (depth == N) {
            String s = "";
            for (int i: list) {
                 s += i;
            }
            int n = Integer.parseInt(s);
            if (num < n) {
                min = Math.min(min, n);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list[depth] = arr[i];
                BT(depth + 1);
                visited[i] = false;
            }
        }
    }

}