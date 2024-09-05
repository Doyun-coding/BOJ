import javax.swing.event.MenuDragMouseListener;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[] arr;
    static int A, X, Y;
    static ArrayList<Node>[] arrayLists;
    static boolean[] visited;
    static boolean[] check;
    static PriorityQueue<DijNode> priorityQueue;

    static void Dijkstra() {
        while(!priorityQueue.isEmpty()) {
            DijNode dijNode = priorityQueue.remove();
            int end = dijNode.getEnd();
            int weight = dijNode.getWeight();

            if(weight > arr[end]) continue;
            arr[end] = weight;

            for(Node node : arrayLists[end]) {
                if(arr[node.getDes()] > weight + arr[node.getEnd()]) {
                    arr[node.getDes()] = weight + arr[node.getEnd()];
                    priorityQueue.add(new DijNode(node.getDes(), arr[node.getDes()]));
                }
            }

        }
    }

    static class DijNode implements Comparable<DijNode> {
        int end;
        int weight;
        DijNode(int end, int weight) {
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
        public int compareTo(DijNode o) {
            return this.weight - o.weight;
        }
    }

    static class Node {
        int start;
        int end;
        int des;
        Node(int end, int des) {
            this.end = end;
            this.des = des;
        }
        Node(int start, int end, int des) {
            this.start = start;
            this.end = end;
            this.des = des;
        }
        int getEnd() {
            return this.end;
        }
        int getDes() {
            return this.des;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }
        arrayLists = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        check = new boolean[N+1];
        priorityQueue = new PriorityQueue<>();

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            arrayLists[X].add(new Node(Y, A));
            arrayLists[Y].add(new Node(X, A));

            priorityQueue.add(new DijNode(A, arr[X] + arr[Y]));
        }

        Dijkstra();

        bw.write(arr[1] + "\n");
        bw.flush();
        bw.close();
    }

}
