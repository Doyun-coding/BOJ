import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int T;
    static int[][] arr;
    static int max = 0;

    static void BackTracking(int depth, int[] temp, boolean[] used) {
        if(depth >= 12) {
            int sum = 0;
            for(int i = 1; i <= 11; i++) {
                sum += temp[i];
            }

            max = Math.max(max, sum);
            return;
        }

        for(int i = 1; i <= 11; i++) {
            if(arr[i][depth] != 0 && !used[i]) {
                temp[depth] = arr[i][depth];
                used[i] = true;
                BackTracking(depth+1, temp, used);
                used[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int t = 1; t <= T; t++) {
            arr = new int[12][12];
            max = 0;
            for(int i = 1; i <= 11; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= 11; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] temp = new int[12];
            boolean[] used = new boolean[12];
            BackTracking(1, temp, used);

            bw.write(max + "\n");

        }
        bw.flush();
        bw.close();
    }
}
