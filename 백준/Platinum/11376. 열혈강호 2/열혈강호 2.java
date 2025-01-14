import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static ArrayList<Integer>[] arrayList;
    static int[] d;
    static boolean[] check;
    static int[] count;
    static int cnt = 0;

    static boolean D(int u) {
        for(int n : arrayList[u]) {
            if(!check[n]) {
                check[n] = true;
                if(d[n] == 0 || D(d[n])) {
                    d[n] = u;
                    return true;
                }
            }
        }
        return false;
    }

    static int DFS(int u) {
        for(int n : arrayList[u]) {
            if(!check[n]) {
                check[n] = true;
                if(count[u] < 2) {
                    if(d[n] == 0 || D(d[n])) {
                        Arrays.fill(check, false);
                        count[u]++;
                        d[n] = u;
                    }
                }
            }
        }
        return count[u];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            for(int j = 1; j <= k; j++) {
                int n = Integer.parseInt(st.nextToken());

                arrayList[i].add(n);
            }
        }

        d = new int[M+1];
        check = new boolean[M+1];
        count = new int[N+1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(check, false);
            Arrays.fill(count, 0);
            for(int j = 1; j <= N; j++) {
                count[j] = 0;
            }

            DFS(i);
        }

        for(int i = 1; i <= M; i++) {
            if(d[i] != 0) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }
}
