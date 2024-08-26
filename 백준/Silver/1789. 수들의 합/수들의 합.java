import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static long S;
    static boolean check = false;
    static StringBuilder sb;

    static void backTracking(int depth, long sum) {
        if(check) return;

        if(sum == S) {
            sb.append(depth + "\n");
            check = true;
            return;
        }

        if(sum > S) return;

        for(int i = depth+1; i < Integer.MAX_VALUE; i++) {
            if(check) return;

            sum += i;
            if(sum > S) break;
            backTracking(depth+1, sum);
            sum -= i;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        S = Long.parseLong(st.nextToken());
        sb = new StringBuilder();

        backTracking(0, 0);

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}
