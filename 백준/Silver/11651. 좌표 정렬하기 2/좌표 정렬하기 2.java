import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int x, y;
    static PriorityQueue<Node> priorityQueue;
    
    static class Node implements Comparable<Node> {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
        
        @Override
        public int compareTo(Node o) {
            if(this.y == o.y) {
                return this.x - o.x;
            }
            else {
                return this.y - o.y;    
            }
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        priorityQueue = new PriorityQueue<>();
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            
            priorityQueue.add(new Node(x, y));
        }
        
        while(!priorityQueue.isEmpty()) {
            Node node = priorityQueue.remove();
            bw.write(node.getX() + " " + node.getY() + "\n");
        }
        bw.flush();
        bw.close();
    }
    
}