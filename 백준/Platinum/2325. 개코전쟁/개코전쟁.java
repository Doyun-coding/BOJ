import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static ArrayList<Node>[] arrayLists;
    static int x, y;
    static long z;
    static long[] dist;
    static boolean[] visited;
    static PriorityQueue<Node> priorityQueue;
    static int[] route;
    static Stack<Integer> stack;
    static long max = 0;

    static void D(int start, int end) {
        for(int i = 1; i <= N; i++) {
            visited[i] = false;
        }

        for(int i = 1; i <= N; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        dist[1] = 0;
        priorityQueue.add(new Node(1, 0));
        while(!priorityQueue.isEmpty()) {
            Node curNode = priorityQueue.remove();
            int u = curNode.getEnd();
            if(!visited[u]) {
                visited[u] = true;

                for(Node node : arrayLists[u]) {
                    if(!visited[node.getEnd()]) {
                        if((u == start && node.getEnd() == end) || (u == end && node.getEnd() == start)) {
                            continue;
                        }
                        else {
                            if (dist[node.getEnd()] > dist[u] + node.getWeight()) {
                                dist[node.getEnd()] = dist[u] + node.getWeight();
                                priorityQueue.add(new Node(node.getEnd(), dist[node.getEnd()]));
                            }
                        }
                    }
                }
            }
        }
    }

    static void Dijkstra() {
        for(int i = 1; i <= N; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        dist[1] = 0;
        route[1] = 0;
        priorityQueue.add(new Node(1, 0));
        while(!priorityQueue.isEmpty()) {
            Node curNode = priorityQueue.remove();
            int u = curNode.getEnd();
            if(!visited[u]) {
                visited[u] = true;

                for(Node node : arrayLists[u]) {
                    if(!visited[node.getEnd()]) {
                        if(dist[node.getEnd()] > dist[u] + node.getWeight()) {
                            dist[node.getEnd()] = dist[u] + node.getWeight();
                            priorityQueue.add(new Node(node.getEnd(), dist[node.getEnd()]));
                            route[node.getEnd()] = u;
                        }
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int start;
        int end;
        long weight;

        Node(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }

        Node(int start, int end, long weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        int getStart() {
            return this.start;
        }
        int getEnd() {
            return this.end;
        }
        long getWeight() {
            return this.weight;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.weight - o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrayLists = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Long.parseLong(st.nextToken());
            arrayLists[x].add(new Node(y, z));
            arrayLists[y].add(new Node(x, z));
        }

        dist = new long[N+1];
        visited = new boolean[N+1];
        priorityQueue = new PriorityQueue<>();
        route = new int[N+1];
        for(int i = 1; i <= N; i++) {
            route[i] = -1;
        }

        Dijkstra();

        stack = new Stack<>();
        int current = N;
        while(current != 1) {
            stack.add(current);
            current = route[current];
        }

        int start = 1;
        int end = 1;
        while(!stack.isEmpty()) {
            start = end;
            end = stack.pop();

            D(start, end);
            max = Math.max(max, dist[N]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
