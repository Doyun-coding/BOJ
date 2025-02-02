import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int R, C, T;
    static int[][] arr;
    static int eat = 0;
    static int X, Y;
    static int max = 0;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void BackTracking(int depth) {
        if(depth == T) {
            max = Math.max(max, eat);

            return;
        }

        for(int i = 0; i < 4; i++) {
            if(X+dx[i] >= 1 && X+dx[i] <= R && Y+dy[i] >= 1 && Y+dy[i] <= C) {
                if(arr[X+dx[i]][Y+dy[i]] != -1) {
                    if(arr[X+dx[i]][Y+dy[i]] == 1) {
                        eat += 1;
                        arr[X+dx[i]][Y+dy[i]] = 0;
                        X = X+dx[i];
                        Y = Y+dy[i];
                        BackTracking(depth+1);
                        X = X-dx[i];
                        Y = Y-dy[i];
                        arr[X+dx[i]][Y+dy[i]] = 1;
                        eat -= 1;
                    }
                    else {
                        X = X+dx[i];
                        Y = Y+dy[i];
                        BackTracking(depth+1);
                        X = X-dx[i];
                        Y = Y-dy[i];
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
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R+1][C+1];

        for(int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            for(int j = 1; j <= C; j++) {
                if(S.charAt(j-1) == '.') {
                    arr[i][j] = 0;
                }
                else if(S.charAt(j-1) == 'G') {
                    arr[i][j] = 0;
                    X = i;
                    Y = j;
                }
                else if(S.charAt(j-1) == '#') {
                    arr[i][j] = -1;
                }
                else if(S.charAt(j-1) == 'S') {
                    arr[i][j] = 1;
                }
            }
        }

        BackTracking(0);

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }
}
