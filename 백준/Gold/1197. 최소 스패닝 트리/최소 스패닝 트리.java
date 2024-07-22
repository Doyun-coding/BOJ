import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int V, E;
    static ArrayList<Node> arrayList;
    static int[] parent;
    static long ans = 0;

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[y] = x;
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
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            arrayList.add(new Node(a, b, c));
        }

        parent = new int[V+1];
        for(int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        Collections.sort(arrayList);

        for(int i = 0; i < arrayList.size(); i++) {
            Node node = arrayList.get(i);
            if(find(node.getStart()) != find(node.getEnd())) {
                ans += node.getCost();
                union(node.getStart(), node.getEnd());
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
