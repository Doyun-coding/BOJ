import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int N, M;
    static long[] A, B;
    static long[] arr;
    static int index = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new long[N+1];
        B = new long[M+1];
        arr = new long[N+M+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            long l = Long.parseLong(st.nextToken());
            A[i] = l;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++) {
            long l = Long.parseLong(st.nextToken());
            B[i] = l;
        }

        int idxA = 1, idxB = 1;
        while(true) {
            if(idxA > N && idxB > M) break;

            if(idxA > N) {
                for(int i = idxB; i <= M; i++) {
                    arr[index] = B[i];
                    index++;
                }
                break;
            }

            if(idxB > M) {
                for(int i = idxA; i <= N; i++) {
                    arr[index] = A[i];
                    index++;
                }
                break;
            }

            if(A[idxA] >= B[idxB]) {
                arr[index] = B[idxB];
                index++;
                idxB++;
            }
            else {
                arr[index] = A[idxA];
                index++;
                idxA++;
            }
        }

        for(int i = 1; i < index; i++) {
            bw.write(arr[i] + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
    }
}
