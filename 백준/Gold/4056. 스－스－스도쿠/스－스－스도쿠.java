import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int T;
    static int[][] arr;
    static int[][][] ans;
    static int cnt = 0;

    static boolean check(int x, int y, int data) {
        for(int i = 1; i <= 9; i++) {
            if(arr[x][i] == data) {
                return false;
            }

            if(arr[i][y] == data) {
                return false;
            }
        }

        int r = (x-1) / 3 * 3;
        int c = (y-1) / 3 * 3;

        for(int i = r+1; i <= r+3; i++) {
            for(int j = c+1; j <= c+3; j++) {
                if(arr[i][j] == data) {
                    return false;
                }
            }
        }

        return true;
    }

    static void sudoku(int x, int y) throws IOException {
        if(x > 9) {
            boolean c = true;
            for(int i = 1; i <= 9; i++) {
                for(int j = 1; j <= 9; j++) {
                    if(arr[i][j] == 0) {
                        c = false;
                        break;
                    }
                }
                if(!c) break;
            }

            if(c) {
                for (int i = 1; i <= 9; i++) {
                    for (int j = 1; j <= 9; j++) {
                        ans[cnt][i][j] = arr[i][j];
                    }
                }
            }
            return;
        }
        if(y > 9) {
            sudoku(x+1, 1);
            return;
        }

        if(arr[x][y] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(check(x, y, i)) {
                    arr[x][y] = i;
                    sudoku(x, y+1);

                }
            }
            arr[x][y] = 0;
            return;
        }
        sudoku(x, y+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        ans = new int[T][10][10];
        for(int t = 1; t <= T; t++) {
            arr = new int[10][10];
            boolean c = true;
            for(int i = 1; i <= 9; i++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for(int j = 1; j <= 9; j++) {
                    int n = Integer.parseInt(String.valueOf(s.charAt(j-1)));
                    if(n != 0 && !check(i, j, n)) {
                        c = false;
                    }
                    arr[i][j] = n;
                }
            }

            if(c) {
                sudoku(1, 1);
            }
            cnt++;
        }
        for(int t = 0; t < T; t++) {
            if(ans[t][1][1] == 0) {
                bw.write("Could not complete this grid.\n\n");
            }
            else {
                for(int i = 1; i <= 9; i++) {
                    for(int j = 1; j <= 9; j++) {
                        bw.write(ans[t][i][j] + "");
                    }
                    bw.write("\n");
                }
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
