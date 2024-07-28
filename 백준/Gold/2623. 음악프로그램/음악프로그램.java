import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int t;
    static ArrayList<Integer>[] arrayLists;
    static boolean[] visited;
    static Stack<Integer> stack;
    static boolean check = true;
    static boolean[] visit;

    static void DFS_TS(int r) {
        visited[r] = true;
        for(int n : arrayLists[r]) {
            if(!visited[n]) {
                DFS_TS(n);
            }
        }

        stack.add(r);
    }

    static void topological() {
        for(int i = 1; i <= N; i++) {
            visited[i] = false;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) DFS_TS(i);
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

        visited = new boolean[N+1];
        stack = new Stack<>();

        for(int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            for(int i = 2; i <= t; i++) {
                int n = Integer.parseInt(st.nextToken());
                arrayLists[p].add(n);
                p = n;
            }
        }

        topological();
        visit = new boolean[N+1];


        while (!stack.isEmpty()) {
            int s = stack.pop();
            visit[s] = true;
            for(int n : arrayLists[s]) {
                if(visit[n]) {
                    check = false;
                    break;
                }
            }
            if(!check) break;
            bw.write(s + "\n");
        }

        if(check) {
            bw.flush();
            bw.close();
        }
        else {
            System.out.println("0\n");
        }
    }
}
