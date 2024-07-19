import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[][] arr;
    static int cnt = 0;

    static void dfs(int x, int y, int now) {
        if(x == N && y == N) {
            cnt++;
            return;
        }

        if(now == 0) {
            if(y+1 <= N && arr[x][y+1] != 1) {
                dfs(x, y+1, 0);
            }

            if(y+1 <= N && x+1 <= N && arr[x][y+1] != 1 && arr[x+1][y] != 1 && arr[x+1][y+1] != 1) {
                dfs(x+1, y+1, 2);
            }
        }
        else if(now == 1) {
            if(x+1 <= N && arr[x+1][y] != 1) {
                dfs(x+1, y, 1);
            }

            if(y+1 <= N && x+1 <= N && arr[x][y+1] != 1 && arr[x+1][y] != 1 && arr[x+1][y+1] != 1) {
                dfs(x+1, y+1, 2);
            }
        }
        else if(now == 2) {
            if(y+1 <= N && arr[x][y+1] != 1) {
                dfs(x, y+1, 0);
            }

            if(x+1 <= N && arr[x+1][y] != 1) {
                dfs(x+1, y, 1);
            }

            if(y+1 <= N && x+1 <= N && arr[x][y+1] != 1 && arr[x+1][y] != 1 && arr[x+1][y+1] != 1) {
                dfs(x+1, y+1, 2);
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
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
            }
        }

        int now = 0;
        int x = 1;
        int y = 2;

        dfs(x, y, now);

        System.out.println(cnt);
    }
}
