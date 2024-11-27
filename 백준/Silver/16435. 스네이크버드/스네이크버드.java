import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            arr[i] = n;
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            int n = arr[i];

            if(n <= L) {
                L++;
            }
            else break;
        }

        bw.write(L + "\n");
        bw.flush();
        bw.close();
    }
}
