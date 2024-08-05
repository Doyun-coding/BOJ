import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N;
    static boolean[] isPrime;
    static int cnt = 0;
    static int[] arr;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        isPrime = new boolean[N+1];

        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(!isPrime[i]) {
                for(int j = i*i; j <= N; j+=i) {
                    isPrime[j] = true;
                }
            }
        }

        int index = 0;
        for(int i = 2; i <= N; i++) {
            if(!isPrime[i]) {
                index++;
                arr[index] = i;
            }
        }

        int now = 1;
        for(int i = 1; i <= index; i++) {
            sum += arr[i];

            if(sum >= N) {
                if(sum == N) cnt++;

                long m = 0;
                if(i == index) {
                    while(true) {
                        sum -= arr[now];
                        now++;

                        if(sum == N) {
                            cnt++;
                            break;
                        }

                        if(sum < N) break;
                    }
                    break;
                }
                else {
                    while(true) {
                        sum -= arr[now];
                        m += arr[now];
                        now++;

                        if(sum == N) cnt++;

                        if(m >= arr[i+1]) break;
                    }
                }
            }
        }

        System.out.println(cnt);

    }
}
