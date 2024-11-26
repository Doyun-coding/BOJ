import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, K;
    static ArrayList<Node> arrayList;
    static ArrayList<Long> bag;
    static long sum = 0;
    static PriorityQueue<Integer> priorityQueue;

    static class Node implements Comparable<Node> {
        int m;
        int v;
        Node(int m, int v) {
            this.m = m;
            this.v = v;
        }
        int getM() {
            return this.m;
        }
        int getV() {
            return this.v;
        }

        @Override
        public int compareTo(Node o) {
            if(this.m == o.m) {
                return o.v - this.v;
            }
            return this.m - o.m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int m, v;
            m = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            arrayList.add(new Node(m, v));
        }

        Collections.sort(arrayList);

        bag = new ArrayList<>();

        for(int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());

            bag.add(n);
        }

        Collections.sort(bag);

        priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int index = 0;
        for(int i = 0; i < bag.size(); i++) {

            while(true) {
                if(index >= N) {
                    break;
                }

                if(bag.get(i) < arrayList.get(index).getM()) break;

                priorityQueue.add(arrayList.get(index).getV());
                index++;
            }

            if(!priorityQueue.isEmpty()) {
                int p = priorityQueue.remove();

                sum += p;
            }

        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
