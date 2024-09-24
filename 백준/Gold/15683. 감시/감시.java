import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;
    static int[][] nCnt;

    static void BackTracking(int x, int y) {
        if(x > N) {
            cnt = 0;
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    if(arr[i][j] == 0) cnt++;
                }
            }

            min = Math.min(min, cnt);
            return;
        }

        if(y > M) {
            BackTracking(x+1, 1);
            return;
        }

        if(arr[x][y] >= 1 && arr[x][y] <= 5) {
            if(arr[x][y] == 1) {
                for(int k = 1; k <= 4; k++) {
                    one(k, x, y, true);
                    BackTracking(x, y+1);
                    one(k, x, y, false);
                }
            }
            else if(arr[x][y] == 2) {
                for(int k = 1; k <= 2; k++) {
                    two(k, x, y, true);
                    BackTracking(x, y+1);
                    two(k, x, y, false);
                }
            }
            else if(arr[x][y] == 3) {
                for(int k = 1; k <= 4; k++) {
                    three(k, x, y, true);
                    BackTracking(x, y+1);
                    three(k, x, y, false);
                }
            }
            else if(arr[x][y] == 4) {
                for(int k = 1; k <= 4; k++) {
                    four(k, x, y, true);
                    BackTracking(x, y+1);
                    four(k, x, y, false);
                }
            }
            else if(arr[x][y] == 5) {
                five(x, y, true);
                BackTracking(x, y+1);
                five(x, y, false);
            }
        }
        BackTracking(x, y + 1);

    }

    static void one(int n, int x, int y, boolean what) {
        if(what) {
            if (n == 1) {
                for (int i = y; i <= M; i++) {
                    if (arr[x][i] == 6) break;
                    else if (arr[x][i] == 0) {
                        arr[x][i] = -1;
                        nCnt[x][i] = 1;
                    }
                    else if(arr[x][i] == -1) nCnt[x][i] += 1;
                }
            } else if (n == 2) {
                for (int i = x; i >= 1; i--) {
                    if (arr[i][y] == 6) break;
                    else if (arr[i][y] == 0) {
                        arr[i][y] = -1;
                        nCnt[i][y] = 1;
                    }
                    else if(arr[i][y] == -1) nCnt[i][y] += 1;
                }
            } else if (n == 3) {
                for (int i = y; i >= 1; i--) {
                    if (arr[x][i] == 6) break;
                    else if (arr[x][i] == 0) {
                        arr[x][i] = -1;
                        nCnt[x][i] = 1;
                    }
                    else if(arr[x][i] == -1) nCnt[x][i] += 1;
                }
            } else if (n == 4) {
                for (int i = x; i <= N; i++) {
                    if (arr[i][y] == 6) break;
                    else if (arr[i][y] == 0) {
                        arr[i][y] = -1;
                        nCnt[i][y] = 1;
                    }
                    else if(arr[i][y] == -1) nCnt[i][y] += 1;
                }
            }
        }
        else {
            if (n == 1) {
                for (int i = y; i <= M; i++) {
                    if (arr[x][i] == 6) break;
                    else if (arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                        nCnt[x][i] -= 1;
                    }
                }
            } else if (n == 2) {
                for (int i = x; i >= 1; i--) {
                    if (arr[i][y] == 6) break;
                    else if (arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
            } else if (n == 3) {
                for (int i = y; i >= 1; i--) {
                    if (arr[x][i] == 6) break;
                    else if (arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                    }
                    nCnt[x][i] -= 1;
                }
            } else if (n == 4) {
                for (int i = x; i <= N; i++) {
                    if (arr[i][y] == 6) break;
                    else if (arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
            }
        }
    }

    static void two(int n, int x, int y, boolean what) {
        if(what) {
            if(n == 1) {
                for(int i = y+1; i <= M; i++) {
                    if(arr[x][i] == 6) break;

                    if(arr[x][i] == 0) {
                        arr[x][i] = -1;
                    }
                    nCnt[x][i] += 1;
                }
                for(int i = y-1; i >= 1; i--) {
                    if(arr[x][i] == 6) break;

                    if(arr[x][i] == 0) {
                        arr[x][i] = -1;
                    }
                    nCnt[x][i] += 1;
                }
            }
            else if(n == 2) {
                for(int i = x-1; i >= 1; i--) {
                    if(arr[i][y] == 6) break;

                    if(arr[i][y] == 0) {
                        arr[i][y] = -1;
                    }
                    nCnt[i][y] += 1;
                }
                for(int i = x+1; i <= N; i++) {
                    if(arr[i][y] == 6) break;

                    if(arr[i][y] == 0) {
                        arr[i][y] = -1;
                    }
                    nCnt[i][y] += 1;
                }
            }
        }
        else {
            if(n == 1) {
                for(int i = y+1; i <= M; i++) {
                    if(arr[x][i] == 6) break;

                    if(arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                        nCnt[x][i] -= 1;
                    }
                }
                for(int i = y-1; i >= 1; i--) {
                    if(arr[x][i] == 6) break;

                    if(arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                        nCnt[x][i] -= 1;
                    }
                }
            }
            else if(n == 2) {
                for(int i = x-1; i >= 1; i--) {
                    if(arr[i][y] == 6) break;

                    if(arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
                for(int i = x+1; i <= N; i++) {
                    if(arr[i][y] == 6) break;

                    if(arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
            }
        }
    }

    static void three(int n, int x, int y, boolean what) {
        if(what) {
            if(n == 1) {
                for(int i = x-1; i >= 1; i--) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == 0) {
                        arr[i][y] = -1;
                    }
                    nCnt[i][y] += 1;
                }
                for(int i = y+1; i <= M; i++) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == 0) {
                        arr[x][i] = -1;
                    }
                    nCnt[x][i] += 1;
                }
            }
            else if(n == 2) {
                for(int i = x-1; i >= 1; i--) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == 0) {
                        arr[i][y] = -1;
                    }
                    nCnt[i][y] += 1;
                }
                for(int i = y-1; i >= 1; i--) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == 0) {
                        arr[x][i] = -1;
                    }
                    nCnt[x][i] += 1;
                }
            }
            else if(n == 3) {
                for(int i = y-1; i >= 1; i--) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == 0) {
                        arr[x][i] = -1;
                    }
                    nCnt[x][i] += 1;
                }
                for(int i = x+1; i <= N; i++) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == 0) {
                        arr[i][y] = -1;
                    }
                    nCnt[i][y] += 1;
                }
            }
            else if(n == 4) {
                for(int i = x+1; i <= N; i++) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == 0) {
                        arr[i][y] = -1;
                    }
                    nCnt[i][y] += 1;
                }
                for(int i = y+1; i <= M; i++) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == 0) {
                        arr[x][i] = -1;
                    }
                    nCnt[x][i] += 1;
                }
            }
        }
        else {
            if(n == 1) {
                for(int i = x-1; i >= 1; i--) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
                for(int i = y+1; i <= M; i++) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                        nCnt[x][i] -= 1;
                    }
                }
            }
            else if(n == 2) {
                for(int i = x-1; i >= 1; i--) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
                for(int i = y-1; i >= 1; i--) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                        nCnt[x][i] -= 1;
                    }
                }
            }
            else if(n == 3) {
                for(int i = y-1; i >= 1; i--) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                        nCnt[x][i] -= 1;
                    }
                }
                for(int i = x+1; i <= N; i++) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
            }
            else if(n == 4) {
                for(int i = x+1; i <= N; i++) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
                for(int i = y+1; i <= M; i++) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                        nCnt[x][i] -= 1;
                    }
                }
            }
        }
    }

    static void four(int n, int x, int y, boolean what) {
        if(what) {
            if(n == 1) {
                for(int i = x-1; i >= 1; i--) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == 0) {
                        arr[i][y] = -1;
                    }
                    nCnt[i][y] += 1;
                }
                for(int i = y+1; i <= M; i++) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == 0) {
                        arr[x][i] = -1;
                    }
                    nCnt[x][i] += 1;
                }
                for(int i = y-1; i >= 1; i--) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == 0) {
                        arr[x][i] = -1;
                    }
                    nCnt[x][i] += 1;
                }
            }
            else if(n == 2) {
                for(int i = y-1; i >= 1; i--) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == 0) {
                        arr[x][i] = -1;
                    }
                    nCnt[x][i] += 1;
                }
                for(int i = x-1; i >= 1; i--) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == 0) {
                        arr[i][y] = -1;
                    }
                    nCnt[i][y] += 1;
                }
                for(int i = x+1; i <= N; i++) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == 0) {
                        arr[i][y] = -1;
                    }
                    nCnt[i][y] += 1;
                }
            }
            else if(n == 3) {
                for(int i = x+1; i <= N; i++) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == 0) {
                        arr[i][y] = -1;
                    }
                    nCnt[i][y] += 1;
                }
                for(int i = y+1; i <= M; i++) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == 0) {
                        arr[x][i] = -1;
                    }
                    nCnt[x][i] += 1;
                }
                for(int i = y-1; i >= 1; i--) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == 0) {
                        arr[x][i] = -1;
                    }
                    nCnt[x][i] += 1;
                }
            }
            else if(n == 4) {
                for(int i = x-1; i >= 1; i--) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == 0) {
                        arr[i][y] = -1;
                    }
                    nCnt[i][y] += 1;
                }
                for(int i = x+1; i <= N; i++) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == 0) {
                        arr[i][y] = -1;
                    }
                    nCnt[i][y] += 1;
                }
                for(int i = y+1; i <= M; i++) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == 0) {
                        arr[x][i] = -1;
                    }
                    nCnt[x][i] += 1;
                }
            }
        }
        else {
            if(n == 1) {
                for(int i = x-1; i >= 1; i--) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
                for(int i = y+1; i <= M; i++) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                        nCnt[x][i] -= 1;
                    }
                }
                for(int i = y-1; i >= 1; i--) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                        nCnt[x][i] -= 1;
                    }
                }
            }
            else if(n == 2) {
                for(int i = y-1; i >= 1; i--) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                        nCnt[x][i] -= 1;
                    }
                }
                for(int i = x-1; i >= 1; i--) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
                for(int i = x+1; i <= N; i++) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
            }
            else if(n == 3) {
                for(int i = x+1; i <= N; i++) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
                for(int i = y+1; i <= M; i++) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                        nCnt[x][i] -= 1;
                    }
                }
                for(int i = y-1; i >= 1; i--) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                        nCnt[x][i] -= 1;
                    }
                }
            }
            else if(n == 4) {
                for(int i = x-1; i >= 1; i--) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
                for(int i = x+1; i <= N; i++) {
                    if(arr[i][y] == 6) break;
                    else if(arr[i][y] == -1) {
                        if(nCnt[i][y] == 1) {
                            arr[i][y] = 0;
                        }
                        nCnt[i][y] -= 1;
                    }
                }
                for(int i = y+1; i <= M; i++) {
                    if(arr[x][i] == 6) break;
                    else if(arr[x][i] == -1) {
                        if(nCnt[x][i] == 1) {
                            arr[x][i] = 0;
                        }
                        nCnt[x][i] -= 1;
                    }
                }
            }
        }
    }

    static void five(int x, int y, boolean what) {
        if(what) {
            for(int i = x-1; i >= 1; i--) {
                if(arr[i][y] == 6) break;
                else if(arr[i][y] == 0) {
                    arr[i][y] = -1;
                }
                nCnt[i][y] += 1;
            }
            for(int i = x+1; i <= N; i++) {
                if(arr[i][y] == 6) break;
                else if(arr[i][y] == 0) {
                    arr[i][y] = -1;
                }
                nCnt[i][y] += 1;
            }
            for(int i = y+1; i <= M; i++) {
                if(arr[x][i] == 6) break;
                else if(arr[x][i] == 0) {
                    arr[x][i] = -1;
                }
                nCnt[x][i] += 1;
            }
            for(int i = y-1; i >= 1; i--) {
                if(arr[x][i] == 6) break;
                else if(arr[x][i] == 0) {
                    arr[x][i] = -1;
                }
                nCnt[x][i] += 1;
            }
        }
        else {
            for(int i = x-1; i >= 1; i--) {
                if(arr[i][y] == 6) break;
                else if(arr[i][y] == -1) {
                    if(nCnt[i][y] == 1) {
                        arr[i][y] = 0;
                    }
                    nCnt[i][y] -= 1;
                }
            }
            for(int i = x+1; i <= N; i++) {
                if(arr[i][y] == 6) break;
                else if(arr[i][y] == -1) {
                    if(nCnt[i][y] == 1) {
                        arr[i][y] = 0;
                    }
                    nCnt[i][y] -= 1;
                }
            }
            for(int i = y+1; i <= M; i++) {
                if(arr[x][i] == 6) break;
                else if(arr[x][i] == -1) {
                    if(nCnt[x][i] == 1) {
                        arr[x][i] = 0;
                    }
                    nCnt[x][i] -= 1;
                }
            }
            for(int i = y-1; i >= 1; i--) {
                if(arr[x][i] == 6) break;
                else if(arr[x][i] == -1) {
                    if(nCnt[x][i] == 1) {
                        arr[x][i] = 0;
                    }
                    nCnt[x][i] -= 1;
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nCnt = new int[N+1][M+1];
        arr = new int[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BackTracking(1, 1);

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

}