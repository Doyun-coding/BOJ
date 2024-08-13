    import java.io.*;
    import java.util.*;

    public class Main {
        static BufferedWriter bw;
        static int N;
        static int[] arr;
        static int T, P;
        static int t = 0;
        static int p = 0;
        static int pp = 0;
        static int sum = 0;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[7];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= 6; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            for(int i = 1; i <= 6; i++) {
                int n = arr[i];
                sum += arr[i];
                while(true) {
                    if(n == 0) break;

                    n -= T;
                    t++;
                    if(n <= 0) {
                        break;
                    }
                }
            }

            p = sum / P;
            pp = sum % P;

            bw.write(t + "\n");
            bw.write(p + " " + pp + "\n");
            bw.flush();
            bw.close();
        }
    }