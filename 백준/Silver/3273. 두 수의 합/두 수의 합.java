import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, X;
    static int[] arr;
    static int cnt = 0;
    static PriorityQueue<Integer> priorityQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        priorityQueue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            priorityQueue.add(n);
        }

        int index = 1;
        while(!priorityQueue.isEmpty()) {
            int p = priorityQueue.remove();
            arr[index] = p;
            index++;
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N; i++) {
            for(int j = i+1; j <= N; j++) {
                if(arr[i] + arr[j] == X) {
                    cnt++;
                }
                if(arr[i] + arr[j] > X) break;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
