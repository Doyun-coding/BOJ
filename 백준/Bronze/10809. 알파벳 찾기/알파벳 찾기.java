import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw;
    static String S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        arr = new int[27];
        for(int i = 0; i <= 26; i++) {
            arr[i] = -1;
        }

        for(int i = 0; i < S.length(); i++) {
            int n = S.charAt(i) - 97;
            if(arr[n] == -1) {
                arr[n] = i;
            }
        }

        for(int i = 0; i <= 25; i++) {
            bw.write(arr[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
