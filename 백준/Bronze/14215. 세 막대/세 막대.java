import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[3];
        arr[0] = A;
        arr[1] = B;
        arr[2] = C;

        Arrays.sort(arr);

        if(arr[0] + arr[1] > arr[2]) {
            bw.write((arr[0]+arr[1]+arr[2]) + "\n");
        }
        else {
            bw.write(((arr[0]+arr[1])*2-1) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
