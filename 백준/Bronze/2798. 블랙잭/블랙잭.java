import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static int[] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }

        Arrays.sort(arr);

        for(int i = 1; i <= N-2; i++) {
            for(int j = i+1; j <= N-1; j++) {
                int idx = j+1;
                while(true) {
                    if(idx > N) {
                        break;
                    }

                    int n = Math.abs(M-max);
                    int sum = arr[i] + arr[j] + arr[idx];

                    if(sum > M) {
                        break;
                    }

                    int m = Math.abs(M-sum);
                    if(n > m) {
                        max = sum;
                    }
                    idx++;
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
