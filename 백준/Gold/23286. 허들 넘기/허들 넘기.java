import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M, T;
    static ArrayList<Node>[] arrayLists;
    static Node[] dest;
    static ArrayList<Integer> ans;
    static int min = 0;
    static boolean[] visited;
    static PriorityQueue<Node> priorityQueue;
    static int[][] routeCost;
    static int[][] route;

    static class Node implements Comparable<Node> {
        int s;
        int e;
        int cost;
        Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
        Node(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
        int getS() {
            return this.s;
        }
        int getE() {
            return this.e;
        }
        int getCost() {
            return this.cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static void Dijkstra(int s) {
        priorityQueue.add(new Node(s, 0));

        while(!priorityQueue.isEmpty()) {
            Node curNode = priorityQueue.remove();
            int u = curNode.getE();
            int cost = curNode.getCost();

            if(!visited[u]) {
                visited[u] = true;

                for(Node node : arrayLists[u]) {
                    if(!visited[node.getE()] && routeCost[s][node.getE()] > node.getCost()) {
                        priorityQueue.add(new Node(node.getE(), node.getCost()));

                        routeCost[s][node.getE()] = Math.min(routeCost[s][node.getE()], node.getCost());
                        route[s][node.getE()] = u;

                    }

                }

            }

        }

    }

    static int findMin(int s, int e) {
        int res = 0;
        for(int i = 1; i <= N; i++) {
            while(e != 0 && e != s) {
                res = Math.max(res, routeCost[s][e]);
                e = route[s][e];
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arrayLists = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        route = new int[N+1][N+1];

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arrayLists[s].add(new Node(e, cost));
        }

        dest = new Node[T+1];
        for(int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            dest[i] = new Node(s, e, -1);
        }

        ans = new ArrayList<>();
        routeCost = new int[N+1][N+1];


        for(int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            priorityQueue = new PriorityQueue<>();
            Arrays.fill(routeCost[i], Integer.MAX_VALUE);
            Dijkstra(i);
        }

        for(int i = 1; i <= T; i++) {
            Node node = dest[i];
            int s = node.getS();
            int e = node.getE();

            int res = findMin(s, e);
            if(res == Integer.MAX_VALUE) res = -1;
            ans.add(res);
        }

//        for(int i = 1; i <= N; i++) {
//            for(int j = 1; j <= N; j++) {
//                System.out.print(route[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//
//        for(int i = 1; i <= N; i++) {
//            for(int j = 1; j <= N; j++) {
//                System.out.print(routeCost[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();


        for(int n : ans) {
            bw.write(n + "\n");
        }
        bw.flush();
        bw.close();
    }
}
