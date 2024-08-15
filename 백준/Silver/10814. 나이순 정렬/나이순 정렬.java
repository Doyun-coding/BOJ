import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static PriorityQueue<Integer> priorityQueue;
    static Queue<String>[] queue;

    static class Node implements Comparable<Node> {
        int age;
        String name;

        Node(int age, String name) {
            this.age = age;
            this.name = name;
        }

        int getAge() {
            return this.age;
        }
        String getName() {
            return this.name;
        }

        @Override
        public int compareTo(Node o) {
            return this.age - o.age;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        priorityQueue = new PriorityQueue<>();
        queue = new Queue[1001];
        for(int i = 0; i <= 1000; i++) {
            queue[i] = new LinkedList<>();
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            queue[n].add(name);
            priorityQueue.add(n);
        }

        while(!priorityQueue.isEmpty()) {
            int n = priorityQueue.remove();
            if(!queue[n].isEmpty()) {
                String s = queue[n].remove();
                bw.write(n + " " + s + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}