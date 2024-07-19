import java.io.*;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static HashSet<Integer> hashSet;
    static PriorityQueue<Integer> priorityQueue;
    static int[] priorityArr;
    static int s = 0;

    static void dfs(int depth, int[] arr) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < priorityArr.length; i++) {
            if(depth == 0) {
                arr[depth] = priorityArr[i];
                dfs(depth + 1, arr);
            }
            else {
                if(arr[depth-1] <= priorityArr[i]) {
                    arr[depth] = priorityArr[i];
                    dfs(depth + 1, arr);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        priorityQueue = new PriorityQueue<>();
        hashSet = new HashSet<>();
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            hashSet.add(n);
        }

        for(int n : hashSet) {
            priorityQueue.add(n);
        }

        s = priorityQueue.size();
        priorityArr = new int[s];

        for(int i = 0; i < s; i++) {
            int p = priorityQueue.remove();
            priorityArr[i] = p;
        }

        int[] arr = new int[M];
        dfs(0, arr);
    }
}
