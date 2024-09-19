import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int V, E;
    static ArrayList<Integer>[] arrayLists;
    static boolean[] cut;
    static int[] count;
    static int cnt = 1;
    static int ans = 0;

    static int DFS(int a, boolean root) {
        count[a] = cnt;
        cnt++;
        int child = 0;
        int min = count[a];

        for(int n : arrayLists[a]) {
            if(count[n] == 0) {
                child++;

                int low = DFS(n, false);

                if(!root && low >= count[a]) {
                    cut[a] = true;
                }
                min = Math.min(min, low);
            }
            else {
                min = Math.min(min, count[n]);
            }
        }

        if(root && child >= 2) {
            cut[a] = true;
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arrayLists = new ArrayList[V+1];
        for(int i = 1; i <= V; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for(int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayLists[a].add(b);
            arrayLists[b].add(a);
        }

        cut = new boolean[V+1];
        count = new int[V+1];
        for(int i = 1; i <= V; i++) {
            count[i] = 0;
        }

        for(int i = 1; i <= V; i++) {
            if(count[i] == 0) {
                DFS(i, true);
            }
        }

        for(int i = 1; i <= V; i++) {
            if(cut[i]) {
                ans++;
            }
        }

        bw.write(ans + "\n");

        for(int i = 1; i <= V; i++) {
            if(cut[i]) {
                bw.write(i + " ");
            }
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
