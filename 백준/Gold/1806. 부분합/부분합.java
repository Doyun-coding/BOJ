import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static long S;
    static long[] arr;
    static int[] dp;
    static int min = Integer.MAX_VALUE;
    static long sum = 0;
    static boolean check = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Long.parseLong(st.nextToken());
        arr = new long[N+1];
        dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int now = 0;
        for(int i = 1; i <= N; i++) {
            sum -= arr[i-1];
            int cnt = dp[i-1] - 1;
            if(i == 1) {
                cnt = 0;
            }
            while(S > sum) {
                now++;
                if(now > N) {
                    check = false;
                    cnt = 0;
                    break;
                }
                sum += arr[now];
                cnt++;
            }
            dp[i] = cnt;
            if(dp[i] != 0) {
                min = Math.min(min, dp[i]);
            }
        }

        if(!check && min == Integer.MAX_VALUE) {
            bw.write("0\n");
        }
        else {
            bw.write(min + "\n");
        }
        bw.flush();
        bw.close();
    }
}
