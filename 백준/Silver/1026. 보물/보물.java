import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[] A;
    static int[] B;
    static PriorityQueue<Integer> priorityQueueA;
    static PriorityQueue<Integer> priorityQueueB;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        B = new int[N+1];
        priorityQueueA = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueueB = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            A[i] = n;
            priorityQueueA.add(n);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            B[i] = n;
            priorityQueueB.add(n);
        }

        for(int i = 1; i <= N; i++) {
            int a = 0;
            int b = 0;
            if(!priorityQueueA.isEmpty()) {
                a = priorityQueueA.remove();
            }

            if(!priorityQueueB.isEmpty()) {
                b = priorityQueueB.remove();
            }
            int c = a * b;
            sum += c;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
