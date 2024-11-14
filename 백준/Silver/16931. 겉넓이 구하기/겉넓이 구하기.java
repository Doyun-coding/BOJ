import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int sum = 0;
    static int[][] arr;
    static Stack<Integer>[] stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];

        sum += N * M * 2;

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
            }
        }

        stack = new Stack[N+1];
        for(int i = 0; i <= N; i++) {
            stack[i] = new Stack<>();
        }

        int m = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(stack[i].isEmpty()) {
                    stack[i].push(arr[i][j]);
                    m = arr[i][j];
                }
                else {
                    int n = stack[i].peek();
                    if(arr[i][j] >= n && arr[i][j-1] != arr[i][j]) {

                        m = arr[i][j];
                        stack[i].push(arr[i][j]);
                    }
                    else {
                        if(n != m) {
                            stack[i].pop();
                        }
                        stack[i].push(arr[i][j]);
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            int pre = 0;
            while(!stack[i].isEmpty()) {
                int n = stack[i].pop();

                if(n > pre) {
                    sum += n - pre;
                }
                pre = n;
            }
        }

        stack = new Stack[N+1];
        for(int i = 0; i <= N; i++) {
            stack[i] = new Stack<>();
        }

        m = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = M; j >= 1; j--) {
                if(stack[i].isEmpty()) {
                    stack[i].push(arr[i][j]);
                    m = arr[i][j];
                }
                else {
                    int n = stack[i].peek();
                    if(arr[i][j] >= n && arr[i][j+1] != arr[i][j]) {

                        m = arr[i][j];
                        stack[i].push(arr[i][j]);
                    }
                    else {
                        if(n != m && arr[i][j] < n) {
                            stack[i].pop();
                        }
                        stack[i].push(arr[i][j]);
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            int pre = 0;
            while(!stack[i].isEmpty()) {
                int n = stack[i].pop();

                if(n > pre) {
                    sum += n - pre;
                }
                pre = n;
            }
        }

        stack = new Stack[M+1];
        for(int i = 0; i <= M; i++) {
            stack[i] = new Stack<>();
        }

        m = 0;
        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j++) {
                if(stack[i].isEmpty()) {
                    stack[i].push(arr[j][i]);
                    m = arr[j][i];
                }
                else {
                    int n = stack[i].peek();
                    if(arr[j][i] >= n && arr[j-1][i] != arr[j][i]) {

                        m = arr[j][i];
                        stack[i].push(arr[j][i]);
                    }
                    else {
                        if(n != m) {
                            stack[i].pop();
                        }

                        stack[i].push(arr[j][i]);
                    }
                }
            }
        }

        for(int i = 1; i <= M; i++) {
            int pre = 0;
            while(!stack[i].isEmpty()) {
                int n = stack[i].pop();
                if(n > pre) {
                    sum += n - pre;
                }
                pre = n;
            }
        }

        stack = new Stack[M+1];
        for(int i = 0; i <= M; i++) {
            stack[i] = new Stack<>();
        }

        m = 0;
        for(int i = 1; i <= M; i++) {
            for(int j = N; j >= 1; j--) {
                if(stack[i].isEmpty()) {
                    stack[i].push(arr[j][i]);
                    m = arr[j][i];
                }
                else {
                    int n = stack[i].peek();
                    if(arr[j][i] >= n && arr[j+1][i] != arr[j][i]) {

                        m = arr[j][i];
                        stack[i].push(arr[j][i]);
                    }
                    else {
                        if(n != m) {
                            stack[i].pop();
                        }

                        stack[i].push(arr[j][i]);
                    }
                }
            }
        }

        for(int i = 1; i <= M; i++) {
            int pre = 0;
            while(!stack[i].isEmpty()) {
                int n = stack[i].pop();
                if(n > pre) {
                    sum += n - pre;
                }
                pre = n;
            }
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
    }
}
