import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[] d;
    static ArrayList<Integer>[] arrayLists;
    static boolean[] check;
    static int cnt = 0;

    static boolean DFS(int u) {
        for(int n : arrayLists[u]) {
            if(!check[n]) {
                check[n] = true;

                if(d[n] == 0 || DFS(d[n])) {
                    d[n] = u;
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrayLists = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        d = new int[M+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            for(int j = 1; j <= k; j++) {
                int n = Integer.parseInt(st.nextToken());

                arrayLists[i].add(n);
            }

        }

        check = new boolean[M+1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(check, false);
            if(DFS(i)) {
                cnt += 1;
            }
        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }
}
