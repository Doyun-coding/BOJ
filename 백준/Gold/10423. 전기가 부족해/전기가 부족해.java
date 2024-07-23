import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M, K;
    static int[] S;
    static ArrayList<Node> arrayList;
    static int[] parent;
    static long ans = 0;
    static boolean[] visited;

    static void full(int x) {
        for(int i = 1; i <= N; i++) {
            if(parent[i] == x) {
                visited[i] = true;
                full(i);
            }
        }
    }

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        boolean yes = false;
        if(x != y) {
            for(int i = 1; i <= K; i++) {
                if(x == S[i]) {
                    parent[y] = x;
                    yes = true;
                    visited[y] = true;
                    full(y);
                    break;
                }
                if(y == S[i]) {
                    parent[x] = y;
                    yes = true;
                    visited[x] = true;
                    full(x);
                    break;
                }
            }
            if(!yes) {
                parent[y] = x;
            }
        }
    }

    static class Node implements Comparable<Node> {
        int start;
        int end;
        long cost;
        Node(int start, int end, long cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        int getStart() {
            return this.start;
        }
        int getEnd() {
            return this.end;
        }
        long getCost() {
            return this.cost;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (cost - o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = new int[N+1];
        visited = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= K; i++) {
            int n = Integer.parseInt(st.nextToken());
            S[i] = n;
            visited[n] = true;
        }

        arrayList = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            arrayList.add(new Node(u, v, w));
        }

        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Collections.sort(arrayList);

        for(int i = 0; i < arrayList.size(); i++) {
            Node node = arrayList.get(i);
            if(find(node.getStart()) != find(node.getEnd())) {
                if(!visited[node.getStart()] || !visited[node.getEnd()]) {
                    ans += node.getCost();
                    union(node.getStart(), node.getEnd());
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
