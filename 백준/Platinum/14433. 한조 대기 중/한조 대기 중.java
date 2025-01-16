import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M, K1, K2;
    static ArrayList<Integer>[] team1;
    static ArrayList<Integer>[] team2;
    static int[] d;
    static boolean[] check;
    static int cnt1 = 0;
    static int cnt2 = 0;

    static boolean DFS1(int u) {
        for(int n : team1[u]) {
            if(!check[n]) {
                check[n] = true;
                if(d[n] == 0 || DFS1(d[n])) {
                    d[n] = u;
                    return true;
                }
            }
        }
        return false;
    }

    static boolean DFS2(int u) {
        for(int n : team2[u]) {
            if(!check[n]) {
                check[n] = true;
                if(d[n] == 0 || DFS2(d[n])) {
                    d[n] = u;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K1 = Integer.parseInt(st.nextToken());
        K2 = Integer.parseInt(st.nextToken());

        team1 = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            team1[i] = new ArrayList<>();
        }

        team2 = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            team2[i] = new ArrayList<>();
        }

        for(int i = 1; i <= K1; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            team1[n].add(m);
        }

        for(int i = 1; i <= K2; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            team2[n].add(m);
        }

        d = new int[M+1];
        check = new boolean[M+1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(check, false);
            if(DFS1(i)) {
                cnt1++;
            }
        }

        d = new int[M+1];
        check = new boolean[M+1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(check, false);
            if(DFS2(i)) {
                cnt2++;
            }
        }

        if(cnt1 >= cnt2) {
            bw.write("그만 알아보자\n");
        }
        else {
            bw.write("네 다음 힐딱이\n");
        }

        bw.flush();
        bw.close();
    }
}
