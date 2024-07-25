import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static long k;
    static int[] parent;
    static ArrayList<Node> arrayList;
    static long ans = 0;
    static boolean check = true;

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

    static void setParent(int  x) {
        if(x == parent[x] || x == 0 || parent[x] == 0) {
            parent[x] = 0;
        }
        else {
            int n = parent[x];
            parent[x] = 0;
            setParent(n);
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        long cost;
        Node(int x, long cost) {
            this.x = x;
            this.cost = cost;
        }
        int getX() {
            return this.x;
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
        k = Long.parseLong(st.nextToken());
        arrayList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arrayList.add(new Node(i, n));
        }

        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        Collections.sort(arrayList);

        for(int i = 0; i < arrayList.size(); i++) {
            Node node = arrayList.get(i);
            int x = node.getX();
            if(find(x) != 0) {
                ans += node.getCost();
                if(ans > k) {
                    check = false;
                    break;
                }
                int y = find(x);
                setParent(x);
                setParent(y);
            }
        }

        if(!check) {
            bw.write("Oh no\n");
        }
        else {
            for(int i = 1; i <= N; i++) {
                if(parent[i] != 0) {
                    check = false;
                    break;
                }
            }

            if(!check) {
                bw.write("Oh no\n");
            }
            else {
                bw.write(ans + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
