import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int N;
    static int[] arr;
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }

        Arrays.sort(arr);

        for(int i = 1; i <= N; i++) {
            int now = 1;
            int index = i;
            int value = arr[i];
            int plus = 0;

            while(true) {
                if(now == 5) break;

                if(index == N) {
                    plus += 5-now;
                    break;
                }

                int n = arr[index+1];
                if(n-value <= 5-now) {
                    if(n-value == 1) {
                        now++;
                        value = n;
                        index++;
                    }
                    else {
                        plus += n-value-1;
                        now += n-value;
                        value = n;
                        index++;
                    }
                }
                else {
                    plus += 5-now;
                    break;
                }

            }
            max = Math.min(max, plus);
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}