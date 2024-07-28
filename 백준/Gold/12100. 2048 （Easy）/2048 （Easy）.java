import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[][] arr;
    static int max = 0;

    static void move(int[][] pre, int m, int depth) {
        boolean[][] visited = new boolean[N+1][N+1];

        int[][] board = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                board[i][j] = pre[i][j];
            }
        }
        if(m == 0) {
            for(int i = 1; i <= N; i++) {
                for(int j = N-1; j >= 1; j--) {
                    if(board[i][j+1] == 0) {
                        board[i][j+1] = board[i][j];
                        if(visited[i][j]) {
                            visited[i][j] = false;
                            visited[i][j+1] = true;
                        }
                        board[i][j] = 0;
                        int now = j+1;
                        while(true) {
                            if(now+1 <= N) {
                                if(board[i][now+1] == 0) {
                                    board[i][now+1] = board[i][now];
                                    if(visited[i][now]) {
                                        visited[i][now] = false;
                                        visited[i][now+1] = true;
                                    }
                                    board[i][now] = 0;
                                    now++;
                                }
                                else if(board[i][now+1] == board[i][now] && !visited[i][now+1] && !visited[i][now]) {
                                    board[i][now+1] += board[i][now];
                                    board[i][now] = 0;
                                    visited[i][now+1] = true;
                                    now++;
                                }
                                else {
                                    break;
                                }
                            }
                            else {
                                break;
                            }
                        }
                    }
                    else if(board[i][j+1] != board[i][j]) {
                        continue;
                    }
                    else if(board[i][j+1] == board[i][j] && !visited[i][j+1] && !visited[i][j]) {
                        board[i][j+1] += board[i][j];
                        board[i][j] = 0;
                        visited[i][j+1] = true;
                    }
                }
            }
        }
        else if(m == 1) {
            for(int i = 1; i <= N; i++) {
                for(int j = 2; j <= N; j++) {
                    if(board[i][j-1] == 0) {
                        board[i][j-1] = board[i][j];
                        board[i][j] = 0;
                        if(visited[i][j]) {
                            visited[i][j] = false;
                            visited[i][j-1] = true;
                        }
                        int now = j-1;
                        while(true) {
                            if(now-1 >= 1) {
                                if(board[i][now-1] == 0) {
                                    board[i][now-1] = board[i][now];
                                    board[i][now] = 0;
                                    if(visited[i][now]) {
                                        visited[i][now] = false;
                                        visited[i][now-1] = true;
                                    }
                                    now--;
                                }
                                else if(board[i][now-1] == board[i][now] && !visited[i][now-1] && !visited[i][now]) {
                                    board[i][now-1] += board[i][now];
                                    board[i][now] = 0;
                                    visited[i][now-1] = true;
                                    now--;
                                }
                                else {
                                    break;
                                }
                            }
                            else {
                                break;
                            }
                        }
                    }
                    else if(board[i][j-1] != board[i][j]) {
                        continue;
                    }
                    else if(board[i][j-1] == board[i][j] && !visited[i][j-1] && !visited[i][j]) {
                        board[i][j-1] += board[i][j];
                        board[i][j] = 0;
                        visited[i][j-1] = true;
                    }
                }
            }
        }
        else if(m == 2) {
            for(int i = 1; i <= N; i++) {
                for(int j = N-1; j >= 1; j--) {
                    if(board[j+1][i] == 0) {
                        board[j+1][i] = board[j][i];
                        board[j][i] = 0;
                        if(visited[j][i]) {
                            visited[j][i] = false;
                            visited[j+1][i] = true;
                        }
                        int now = j+1;
                        while(true) {
                            if(now+1 <= N) {
                                if(board[now+1][i] == 0) {
                                    board[now+1][i] = board[now][i];
                                    board[now][i] = 0;
                                    if(visited[now][i]) {
                                        visited[now][i] = false;
                                        visited[now+1][i] = true;
                                    }
                                    now++;
                                }
                                else if(board[now+1][i] == board[now][i] && !visited[now+1][i] && !visited[now][i]) {
                                    board[now+1][i] += board[now][i];
                                    board[now][i] = 0;
                                    visited[now+1][i] = true;
                                    now++;
                                }
                                else {
                                    break;
                                }
                            }
                            else {
                                break;
                            }
                        }
                    }
                    else if(board[j+1][i] != board[j][i]) {
                        continue;
                    }
                    else if(board[j+1][i] == board[j][i] && !visited[j+1][i] && !visited[j][i]) {
                        board[j+1][i] += board[j][i];
                        board[j][i] = 0;
                        visited[j+1][i] = true;
                    }
                }
            }
        }
        else if(m == 3) {
            for(int i = 1; i <= N; i++) {
                for(int j = 2; j <= N; j++) {
                    if(board[j-1][i] == 0) {
                        board[j-1][i] = board[j][i];
                        board[j][i] = 0;
                        if(visited[j][i]) {
                            visited[j][i] = false;
                            visited[j-1][i] = true;
                        }
                        int now = j-1;
                        while(true) {
                            if(now-1 >= 1) {
                                if(board[now-1][i] == 0) {
                                    board[now-1][i] = board[now][i];
                                    board[now][i] = 0;
                                    if(visited[now][i]) {
                                        visited[now][i] = false;
                                        visited[now-1][i] = true;
                                    }
                                    now--;
                                }
                                else if(board[now-1][i] == board[now][i] && !visited[now-1][i] && !visited[now][i]) {
                                    board[now-1][i] += board[now][i];
                                    board[now][i] = 0;
                                    visited[now-1][i] = true;
                                    now--;
                                }
                                else {
                                    break;
                                }
                            }
                            else {
                                break;
                            }
                        }
                    }
                    else if(board[j-1][i] != board[j][i]) {
                        continue;
                    }
                    else if(board[j-1][i] == board[j][i] && !visited[j-1][i] && !visited[j][i]) {
                        board[j-1][i] += board[j][i];
                        board[j][i] = 0;
                        visited[j-1][i] = true;
                    }
                }
            }
        }

        backTracking(board, depth+1);
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                board[i][j] = pre[i][j];
            }
        }
    }

    static void backTracking(int[][] board, int depth) {
        if(depth >= 5) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    max = Math.max(board[i][j], max);
                }
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            move(board, i, depth);
        }
//        move(board, 0, depth);
//        move(board, 2, depth);
//        move(board, 3, depth);
//        move(board, 0, depth);
//        move(board, 1, depth);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        int[][] board = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
                board[i][j] = n;
            }
        }

        backTracking(board, 0);

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
