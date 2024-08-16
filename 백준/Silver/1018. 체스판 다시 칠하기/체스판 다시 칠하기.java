import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static boolean[][] bBoard;
    static boolean[][] mBoard;
    static boolean[][] BM;
    static int bCnt = 0;
    static int mCnt = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bBoard = new boolean[9][9];
        mBoard = new boolean[9][9];
        BM = new boolean[N+1][M+1];

        for(int i = 1; i <= 8; i++) {
            for(int j = 1; j <= 8; j++) {
                if(i % 2 == 0) {
                    if(j % 2 ==0) {
                        mBoard[i][j] = true;
                        bBoard[i][j] = false;
                    }
                    else {
                        bBoard[i][j] = true;
                        mBoard[i][j] = false;
                    }
                }
                else {
                    if(j % 2 == 0) {
                        bBoard[i][j] = true;
                        mBoard[i][j] = false;
                    }
                    else {
                        mBoard[i][j] = true;
                        bBoard[i][j] = false;
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            for(int j = 1; j <= M; j++) {
                if(S.charAt(j-1) == 'B') {
                    BM[i][j] = false;
                }
                else {
                    BM[i][j] = true;
                }
            }
        }

        for(int i = 1; i <= N-7; i++) {
            for(int j = 1; j <= M-7; j++) {
                bCnt = 0;
                mCnt = 0;

                for(int n = i; n <= i+7; n++) {
                    for(int m = j; m <= j+7; m++) {
                        if(bBoard[n-i+1][m-j+1] == BM[n][m]) {
                            mCnt++;
                        }
                        else {
                            bCnt++;
                        }
                    }
                }

                min = Math.min(min, Math.min(mCnt, bCnt));
            }
        }
        bw.write(min + "\n");

        bw.flush();
        bw.close();
    }
}
