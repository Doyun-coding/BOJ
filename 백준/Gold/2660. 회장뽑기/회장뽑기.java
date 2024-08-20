import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static int[] friend;
    static int cnt = 0;
    static Queue<Integer> queue;

    static void FloydWarshall() {

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(i != j) {
                        if(arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE) {
                            if(arr[i][j] > arr[i][k] + arr[k][j]) {
                                arr[i][j] = arr[i][k] + arr[k][j];
                            }
                        }
                    }
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
        arr = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                arr[i][j] = Integer.MAX_VALUE;
            }
        }

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1) {
                break;
            }

            arr[a][b] = 1;
            arr[b][a] = 1;

            FloydWarshall();

        }

        friend = new int[N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i != j) {
                    if(arr[i][j] == Integer.MAX_VALUE) {
                        friend[i] = -1;
                        break;
                    }
                    else {
                        int n = arr[i][j];
                        friend[i] = Math.max(friend[i], n);
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            if(friend[i] != -1) {
                min = Math.min(min, friend[i]);
            }
        }

        queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(friend[i] == min) {
                cnt++;
                queue.add(i);
            }
        }

        bw.write(min + " " + cnt + "\n");
        while(!queue.isEmpty()) {
            int q = queue.remove();
            bw.write(q + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
