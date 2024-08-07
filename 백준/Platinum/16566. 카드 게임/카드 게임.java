import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N, M, K;
    static int[] counter;
    static List<Integer> list;
    static int[] parent;

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x > y) {
                parent[y] = x;
            }
            else {
                parent[x] = y;
            }
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
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++) {
            int n = Integer.parseInt(st.nextToken());
            list.add(n);
        }
        Collections.sort(list);
        parent = new int[M];
        for(int i = 0; i < M; i++) {
            parent[i] = i;
        }

        counter = new int[K+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= K; i++) {
            counter[i] = Integer.parseInt(st.nextToken());
        }

        int r = 0;
        int size = list.size();
        for(int k = 1; k <= K; k++) {
            int left = 0;
            int right = size-1;

            while (true) {
                if (left == right) break;

                int mid = (left + right) / 2;

                if (list.get(mid) == counter[k]) {
                    left = mid + 1;
                    break;
                } else if (list.get(mid) > counter[k]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            r = find(left);
            bw.write(list.get(r) + "\n");
            if(r != size-1) {
                union(r+1, r);
            }

        }

        bw.flush();
        bw.close();
    }
}
