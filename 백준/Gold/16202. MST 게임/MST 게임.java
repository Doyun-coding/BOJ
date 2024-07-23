import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M, K;
    static ArrayList<Node> arrayList;
    static int[] parent;
    static int ans = 0;
    static boolean[] visited;
    static boolean[] delete;
    static int cnt = 0;

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

    static void MST() {
        int n = 0;
        for(int i = 1; i <= M; i++) {
            if(visited[i]) {
                n = i;
                break;
            }
        }

        delete[n] = true;
        for(int i = 1; i <= M; i++) {
            visited[i] = false;
        }
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
        int getCost() {
            return this.cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
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
        arrayList = new ArrayList<>();
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = i;
            arrayList.add(new Node(x, y, w));
        }

        Collections.sort(arrayList);

        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        visited = new boolean[M+1];
        delete = new boolean[M+1];
        for(int i = 0; i < arrayList.size(); i++) {
            Node node = arrayList.get(i);
            if(find(node.getX()) != find(node.getY())) {
                ans += node.getCost();
                cnt++;
                visited[node.getCost()] = true;
                union(node.getX(), node.getY());
            }
        }

        if(cnt+1 == N) {
            bw.write(ans + " ");
        }
        else {
            ans = 0;
            bw.write(ans + " ");
        }

        for(int i = 2; i <= K; i++) {
            cnt = 0;
            if(ans != 0) {
                ans = 0;
                MST();
                for(int j = 0; j < arrayList.size(); j++) {
                    if(!delete[j+1]) {
                        Node node = arrayList.get(j);
                        if (find(node.getX()) != find(node.getY())) {
                            ans += node.getCost();
                            cnt++;
                            visited[node.getCost()] = true;
                            union(node.getX(), node.getY());
                        }
                    }
                }

                if(cnt+1 == N) {
                    bw.write(ans + " ");
                }
                else {
                    ans = 0;
                    bw.write(ans + " ");
                }
            }
            else {
                bw.write("0 ");
            }
        }
        bw.write("\n");

        bw.flush();
        bw.close();
    }
}
