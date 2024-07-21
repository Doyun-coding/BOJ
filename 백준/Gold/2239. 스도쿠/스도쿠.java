import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int[][] arr;
    static boolean c = false;

    static boolean check(int x, int y, int data) {
        for(int i = 1; i <= 9; i++) {
            if(arr[x][i] == data) {
                return false;
            }

            if(arr[i][y] == data) {
                return false;
            }
        }

        int c = (x-1) / 3 * 3;
        int r = (y-1) / 3 * 3;

        for(int i = c+1; i <= c+3; i++) {
            for(int j = r+1; j <= r+3; j++) {
                if(arr[i][j] == data) {
                    return false;
                }
            }
        }

        return true;
    }

    static void sudoku(int x, int y) throws IOException {
        if(c) return;

        if(y > 9) {
            sudoku(x+1, 1);
            return;
        }

        if(x > 9) {
            for(int i = 1; i <= 9; i++) {
                for(int j = 1; j <= 9; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            c = true;
            return;
        }

        if(arr[x][y] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(check(x, y, i)) {
                    arr[x][y] = i;
                    sudoku(x, y+1);
                    if(c) return;
                    arr[x][y] = 0;
                }
            }
        }
        else {
            sudoku(x, y+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[10][10];

        for(int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 1; j <= 9; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j-1)));
            }
        }

        sudoku(1, 1);

    }
}
