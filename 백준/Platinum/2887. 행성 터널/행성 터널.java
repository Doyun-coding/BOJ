import javax.swing.event.MenuDragMouseListener;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static ArrayList<Node> arrayList;
    static PriorityQueue<Com> priorityQueue;
    static int[] parent;
    static long dist = 0;

    static class Com implements Comparable<Com> {
        int start;
        int end;
        int d;
        Com(int start, int end, int d) {
           this.start = start;
           this.end = end;
           this.d = d;
        }
        int getStart() {
            return this.start;
        }
        int getEnd() {
            return this.end;
        }
        int getD() {
            return this.d;
        }

        @Override
        public int compareTo(Com o) {
            return this.d - o.d;
        }
    }

    static class Node {
        int x;
        int y;
        int z;
        int num;
        Node(int x, int y, int z, int num) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.num = num;
        }

        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
        int getZ() {
            return this.z;
        }
        int getNum() {
            return this.num;
        }
    }

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            arrayList.add(new Node(x, y, z, i));
        }

        priorityQueue = new PriorityQueue<>();

        arrayList.sort(Comparator.comparingInt(node -> node.getX()));
        for(int i = 0; i < arrayList.size()-1; i++) {
            Node startNode = arrayList.get(i);
            Node endNode = arrayList.get(i+1);
            priorityQueue.add(new Com(startNode.num, endNode.num, Math.abs(endNode.getX()-startNode.getX())));
        }

        arrayList.sort(Comparator.comparingInt(node -> node.getY()));
        for(int i = 0; i < arrayList.size()-1; i++) {
            Node startNode = arrayList.get(i);
            Node endNode = arrayList.get(i+1);
            priorityQueue.add(new Com(startNode.num, endNode.num, Math.abs(endNode.getY()- startNode.getY())));
        }

        arrayList.sort(Comparator.comparingInt(node -> node.getZ()));
        for(int i = 0; i < arrayList.size()-1; i++) {
            Node startNode = arrayList.get(i);
            Node endNode = arrayList.get(i+1);
            priorityQueue.add(new Com(startNode.num, endNode.num, Math.abs(endNode.getZ()-startNode.getZ())));
        }

        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        while(!priorityQueue.isEmpty()) {
            Com com = priorityQueue.remove();
            if(find(com.getStart()) != find(com.getEnd())) {
                union(find(com.getStart()), find(com.getEnd()));
                dist += com.getD();
            }
        }

        bw.write(dist + "\n");
        bw.flush();
        bw.close();
    }
}
