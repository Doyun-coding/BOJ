import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, V, E;
    static int A, B;
    static ArrayList<Node>[] arrayLists;
    static ArrayList<Integer> start;
    static int[] dist;
    static boolean[] visited;
    static PriorityQueue<Node> priorityQueue;
    static int min = 0;

    static void Dijkstra(int x) {
        for(int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[x] = 0;

        priorityQueue.add(new Node(x, 0));
        while(!priorityQueue.isEmpty()) {
            Node curNode = priorityQueue.remove();
            int u = curNode.getEnd();

            if(visited[A] && visited[B]) return;

            if(!visited[u]) {
                visited[u] = true;
                for(Node node : arrayLists[u]) {
                    if(!visited[node.getEnd()] && dist[node.getEnd()] > dist[u] + node.getWeight()) {
                        dist[node.getEnd()] = dist[u] + node.getWeight();
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[V+1];
        for(int i = 0; i <= V; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        start = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            start.add(n);
        }

        for(int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            arrayLists[a].add(new Node(b, l));
            arrayLists[b].add(new Node(a, l));
        }

        dist = new int[V+1];
        for(int n : start) {
            visited = new boolean[V+1];
            priorityQueue = new PriorityQueue<>();
            Dijkstra(n);

            if(dist[A] == Integer.MAX_VALUE) {
                min += -1;
            }
            else {
                min += dist[A];
            }

            if(dist[B] == Integer.MAX_VALUE) {
                min += -1;
            }
            else {
                min += dist[B];
            }

        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}
