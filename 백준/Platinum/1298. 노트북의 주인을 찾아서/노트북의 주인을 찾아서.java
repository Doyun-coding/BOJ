import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static ArrayList<Integer>[] arrayLists;
    static int[] d;
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
        for(int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayLists[a].add(b);
        }

        d = new int[N+1];
        check = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(check, false);
            if(DFS(i)) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }
}
