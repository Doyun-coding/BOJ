import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[][] arr;
    static int T = 0;

    static boolean check() {
        for(int i = 1; i <= 9; i++) {
            boolean[] arrX = new boolean[10];
            boolean[] arrY = new boolean[10];
            for(int j = 1; j <= 9; j++) {
                int y = arr[i][j];
                int x = arr[j][i];
                if(arrX[y]) {
                    return false;
                }
                if(arrY[x]) {
                    return false;
                }
                arrX[y] = true;
                arrY[x] = true;
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int r = i * 3;
                int c = j * 3;
                boolean[] arrXY = new boolean[10];
                for(int n = r+1; n <= r+3; n++) {
                    for(int m = c+1; m <= c+3; m++) {
                        int v = arr[n][m];
                        if(arrXY[v]) {
                            return false;
                        }
                        arrXY[v] = true;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[10][10];
        for(int i = 1; i <= N; i++) {
            T++;
            for(int n = 1; n <= 9; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m = 1; m <= 9; m++) {
                    arr[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            if(check()) {
                System.out.println("Case " + T + ": CORRECT");
            }
            else {
                System.out.println("Case " + T + ": INCORRECT");
            }

            if(i != N) {
                st = new StringTokenizer(br.readLine());
            }
        }
    }
}
