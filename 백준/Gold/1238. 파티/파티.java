import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N, M, X;
    static ArrayList<Node>[] arrayLists;
    static int[] dist;
    static boolean[] visited;
    static PriorityQueue<Node> priorityQueue;
    static int max = 0;
    static int[] go;

    static void comeDijkstra(int x) {
        for(int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[x] = 0;

        priorityQueue.add(new Node(x, 0));
        while(!priorityQueue.isEmpty()) {
            Node curNode = priorityQueue.remove();
            int e = curNode.getEnd();
            if(!visited[e]) {
                visited[e] = true;
                for(Node node : arrayLists[e]) {
                    if(!visited[node.getEnd()] && dist[node.getEnd()] > dist[e] + node.getWeight()) {
                        dist[node.getEnd()] = dist[e] + node.getWeight();
                        priorityQueue.add(new Node(node.getEnd(), dist[node.getEnd()]));
                    }
                }
            }
        }

    }

    static void Dijkstra(int x) {
        for(int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[x] = 0;

        priorityQueue.add(new Node(x, 0));
        while(!priorityQueue.isEmpty()) {
            Node curNode = priorityQueue.remove();
            int e = curNode.getEnd();

            if(visited[X]) return;

            if(!visited[e]) {
                visited[e] = true;
                for(Node node : arrayLists[e]) {
                    if(!visited[node.getEnd()] && dist[node.getEnd()] > dist[e] + node.getWeight()) {
                        dist[node.getEnd()] = dist[e] + node.getWeight();
                        priorityQueue.add(new Node(node.getEnd(), dist[node.getEnd()]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        int getEnd() {
            return this.end;
        }
        int getWeight() {
            return this.weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arrayLists = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        go = new int[N+1];

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            arrayLists[s].add(new Node(e, t));
        }

        dist = new int[N+1];

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            priorityQueue = new PriorityQueue<>();

            if(i == X) continue;

            Dijkstra(i);

            go[i] = dist[X];
        }

        visited = new boolean[N+1];
        priorityQueue = new PriorityQueue<>();
        comeDijkstra(X);

        for(int i = 1; i <= N; i++) {
            go[i] += dist[i];
            max = Math.max(max, go[i]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

}