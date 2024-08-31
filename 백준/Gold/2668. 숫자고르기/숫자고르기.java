import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[] arr;
    static boolean[] visited;
    static Queue<Integer> queue;
    static PriorityQueue<Integer> priorityQueue;
    static Queue<Integer> ans;

    static void searchCircle(int x) {
        boolean[] check = new boolean[N+1];
        queue.add(arr[x]);
        ans.add(x);
        while(!queue.isEmpty()) {
            int n = queue.remove();

            if(n == x) break;

            if(!visited[n] && !check[n]) {
                check[n] = true;
                ans.add(n);
                queue.add(arr[n]);
            }
            else {
                return;
            }
        }

        if(queue.isEmpty()) {
            while(!ans.isEmpty()) {
                int n = ans.remove();
                visited[n] = true;
                priorityQueue.add(n);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N+1];
        priorityQueue = new PriorityQueue<>();


        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                queue = new LinkedList<>();
                ans = new LinkedList<>();
                searchCircle(i);
            }
        }

        int length = priorityQueue.size();
        bw.write(length + "\n");
        while(!priorityQueue.isEmpty()) {
            int p = priorityQueue.remove();
            bw.write(p + "\n");
        }
        bw.flush();
        bw.close();
    }
}
