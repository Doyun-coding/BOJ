import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[] arr;
    static int[] cnt;
    static int max = 0;

    static boolean check(int dx, int dy, int a, int b, int x, int y) {
        if(dx == 0) return false;

        double v = ((double) (x-a) * ( (double)dy / (double) dx)) + (double) b;

        if(y >= v) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        cnt = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = i+1; j <= N; j++) {
                if(i+1 == j) {
                    cnt[i] += 1;
                    cnt[j] += 1;
                    continue;
                }

                int x1 = i;
                int y1 = arr[i];
                int x2 = j;
                int y2 = arr[j];

                int dx = x2-x1;
                int dy = y2-y1;

                boolean c = true;

                for(int k = i+1; k < j; k++) {
                    if(!check(dx, dy, x1, y1, k, arr[k])) {
                        c = false;
                        break;
                    }
                }

                if(c) {
                    cnt[x1] += 1;
                    cnt[x2] += 1;
                }

            }
        }

        for(int i = 1; i <= N; i++) {
            max = Math.max(max, cnt[i]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
