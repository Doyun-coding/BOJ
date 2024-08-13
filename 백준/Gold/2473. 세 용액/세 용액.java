import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[] arr;
    static long min = Long.MAX_VALUE;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        ans = new int[3];

        for(int i = 0; i < N-2; i++) {
            if(min == 0) break;

            long sum = 0;
            for(int j = i+1; j < N-1; j++) {
                sum = arr[i] + arr[j];

                int left = j + 1;
                int right = N-1;
                while(true) {
                    if(left > right) {
                        break;
                    }

                    int mid = (left + right) / 2;
                    long m = sum + arr[mid];
                    if(Math.abs(m) < Math.abs(min)) {
                        min = m;
                        ans[0] = arr[i];
                        ans[1] = arr[j];
                        ans[2] = arr[mid];
                    }


                    if(m > 0) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
