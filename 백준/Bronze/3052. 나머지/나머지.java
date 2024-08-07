import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[43];

        for(int i = 1; i <= 10; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            n %= 42;
            arr[n] = 1;
        }
        int sum = 0;
        for(int i = 0; i <= 42; i++) {
            sum += arr[i];
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
