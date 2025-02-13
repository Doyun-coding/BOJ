import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int T;
    static int x1, y1, x2, y2;
    static int cnt = 0;

    static boolean inCircle(int x, int y, int r) {
        long dist1 = (long) (Math.pow(x1-x, 2) + Math.pow(y1-y, 2));
        long dist2 = (long) (Math.pow(x2-x, 2) + Math.pow(y2-y, 2));
        long R = (long) Math.pow(r, 2);

        if(dist1 > R && dist2 < R) return true;
        if(dist1 < R && dist2 > R) return true;

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            cnt = 0;
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());

            for(int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                if (inCircle(x, y, r)) {
                    cnt++;
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
    }
}
